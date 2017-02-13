---
layout: default
title: Performing Classification Task Using PySpark
categories: project
excerpt_separator: <!--more-->
---
<img src="http://spark.apache.org/images/spark-logo-trademark.png" style="float:right;width:256px;"/> 
# Performing Classification Task Using PySpark
[Spark](http://spark.apache.org/) has been a popular cloud computing technology in recently years.  
I guess the reason why it gets everybody's attension is that it's speedier compared with Hadoop's MapReduce. 
In fact they are tools for different purposes, though overlap partially. For those interested in the differences, check out [Five things you need to know about Hadoop v. Apache Spark](http://www.infoworld.com/article/3014440/big-data/five-things-you-need-to-know-about-hadoop-v-apache-spark.html).  
As an NLP and Machine Learning guy, probably one thing excites me the most is the fact that Spark not only supports common programming languages such as Java, Python and Scala, it also comes with a bunch of built-in machine learning packages. You can directly call those ML algorithms! How cool and convenient!!  
In this post, I'm going to share how I use Spark and python (the PySpark) to do a simple sentiment classification task.  
Note: This post doesn't cover how to setup Apache Spark on your computer. Please google it and you can find rich results on it; or check out [this](https://www.tutorialspoint.com/apache_spark/apache_spark_installation.htm).  
### Step 1. Data Preparation
Download [this archived file](../Data/SentimentCLData.zip).  
The following diagram shows the data folder structure.   
![Data folder structure](/images/PySparkClassification/Data_folder.png)  
In this task, we are going to perform 2 classification tasks: You can see the posts are categoried into positive-negative in the first level; at the second level, the posts are further categorized into truthful and deceptive.  
Instead of doing 2 classification separately, we're going to do it at once.  
Note that where the post locates is the label for each post.  
### Step 2. Implmentation in Python
The classifier to be used is the NaiveBayes, and we use unigram as features. Since it's an NLP task, we expect the dimension of the feature vector to be very large, therefore using SpareVector data structure is a smarter choice.  

1. Import the packages we needed.
	
	```python
	import os
	import re
	import sys
	import fnmatch
	from pyspark.mllib.linalg import SparseVector	
	from pyspark.mllib.regression import LabeledPoint
	from pyspark.mllib.classification import NaiveBayes
	from pyspark import SparkContext
	```
2. Set the labels for 4 classes as well as the data structures later to be used.
	
	```python
	top_path = os.path.join(os.getcwd(), 'Data');
	nd = '/negative_polarity/deceptive_from_MTurk'
	nt = '/negative_polarity/truthful_from_Web'
	pd = '/positive_polarity/deceptive_from_MTurk'
	pt = '/positive_polarity/truthful_from_TripAdvisor'
	classes = [nd, nt, pd, pt]		#0.25, 0.5, 0.75. 1
	class_list = [[], [], [], []]	#tracking toekn occurrences for each class
	word_to_id = {}					#map a word to an int id
	feature_max = {}				#this is for normalization use
	```
3. The main function give the structure of the algorithm: first extract features from training set and store these information in the global data structure we defined earlier. Next, extract features for the predict set and return the feature vectors for the predict set. Then do the training and obtain the model. Use the model and the feature vectors of the predict set to run prediction. Finally, outout F-scores for the 2 classification tasks.  

	```python
	def main():
		getTrainingFeatures()		
		predictSet = getPredictionFeatures()
		model = training()
		predictSet = runPrediction(model, predictSet)
		for i in [0, 1]:
			print Fscore(predictSet, i)
	```
4. getTrainningFeatures() function: the add_dict(word, dictionary) is an auxiliary function to help adding words and mapping word to an integer id. For normalization needs, we also trace the global maximum of values in each dimenstion here.  
The function loops through each .txt files in the training set, creates a feature vector for each file, and categorizes these vectors with their labels.
Note that we also perform basic preprocessing to filter out punctuation and stop words.

	```python
	def getTrainningFeatures():
		def add_dict(word, dictionary):		#occurrence tracking
			if word not in word_to_id:
				word_to_id[word] = len(word_to_id)
			word_id = word_to_id[word]
			if word_id in dictionary:
				dictionary[word_id] += 1
			else:
				dictionary[word_id] = 1
			feature_max[word_id] = max(feature_max.get(word_id, 0), dictionary[word_id])
		for i in xrange(len(classes)):
			class_dir = top_path + classes[i]
			current_class_list = class_list[i]
			
		subdirs = [ name for name in os.listdir(class_dir) if os.path.isdir(os.path.join(class_dir, name)) ]
		for j in subdirs:
			current_dir = class_dir+"/"+j
			files = os.listdir(current_dir)
			#print listing		
			for k in files:
				features = {}
				if ".txt" not in k:
					continue
				with open(current_dir+"/"+k, "r") as c_file:
					for line in c_file:
						tokens = preprocess(line)
						for x in tokens:
							add_dict(x, features)
				current_class_list.append(features)
	```
5. getPredictionFeatures() does similar things as to the getTrainningFeatures() function. Only here we would just skip unknown words. I am going to skip the code here.  
6. training())) function. This is where the Spark comes into play. First allocate a SparkContext. We are running this example in local only, so use "loca" and "Simple App" as arguments.  
We are going to parallelize the training process. Creating the training data in LabeledPoint format, and then applied sc.parallelize() to it. The output data will be executed in parallel. Use NaiveBayes.train() to get the model and returns it.

	```python
	def training():
		sc = SparkContext("local", "Simple App")
		trainingSet = list()				
		for i in xrange(len(classes)):
			current_class_list = class_list[i]
			label = (i+1)/float(len(classes))
			for features in current_class_list:
				for key in features:	
					features[key] = float(features[key])/float(feature_max[key])
				trainingSet.append(LabeledPoint(label, SparseVector(len(word_to_id), features)) )

		# training model
		data = sc.parallelize(trainingSet)
		model = NaiveBayes.train(data, 1.0)
		return model
	```
6. runPrediction() function is simple: loop through each vector in predictSet and run prediction with the trained model. We do the conversion from numerical label value to a list for later computation of F-score.

	```python
	def runPrediction(model, predictSet):
		for predict in predictSet:
			p = model.predict(predict[1])
			ans = list()
			if p == 0.25:
				ans = ['deceptive', 'negative']
			elif p == 0.5:
				ans = ['truthful', 'negative']
			elif p == 0.75:
				ans = ['deceptive', 'positive']
			else:
				ans = ['truthful', 'positive']
			predict.append(ans)
		return predictSet
	```
7. Fscore() function takes the prediction results, compares with the correct result and outputs the Fsocre.  
F1-score = <span class="inlinecode">$\frac{2 \cdot precision \cdot recall}{precision+recall}$</span>

	```python
	def Fscore(predict, i):
		tp = fp = tn = fn = 0
		for j in xrange(0, len(predict)):
			if i == 0:
				if predict[j][0][0] == 'truthful' and predict[j][2][0] == 'truthful':
					tp += 1
				elif predict[j][0][0] == 'truthful' and predict[j][2][0] == 'deceptive':
					fp += 1
				elif predict[j][0][0] == 'deceptive' and predict[j][2][0] == 'deceptive':
					tn += 1
				elif predict[j][0][0] == 'deceptive' and predict[j][2][0] == 'truthful':
					fn += 1
			if i == 1:
				if predict[j][0][1] == 'positive' and predict[j][2][1] == 'positive':
					tp += 1
				elif predict[j][0][1] == 'positive' and predict[j][2][1] == 'negative':
					fp += 1
				elif predict[j][0][1] == 'negative' and predict[j][2][1] == 'negative':
					tn += 1
				elif predict[j][0][1] == 'negative' and predict[j][2][1] == 'positive':
					fn += 1
		precision = float(tp)/float(tp+fp)
		recall = float(tp)/float(tp+fn)
		return (2*precision*recall)/(precision+recall)
	```
The complete source code can be found on my [Github](https://github.com/tyge318/PySparkClassification).