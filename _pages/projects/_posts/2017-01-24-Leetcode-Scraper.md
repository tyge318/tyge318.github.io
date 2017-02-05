---
layout: default
title: Leetcode Scraper
categories: [project]
excerpt_separator: <!--more-->
---
# How to backup all your Leetcode submissions to a local computer?
I have been preparing coding interviews with Leetcode, and in the past year I completed much of the problems posted.  
At some point you just want to have a copy of all your submitted codes. Or in my case, you want to put whatever you've coded on Git to make your Github looks awesome.  
Apparently you don't want to perform this task manually. And as a geek, all you can do about this is to write a small tool to do it for you.
So there's a problem: **you need to login in order to access all your previous submissions.**  
Maybe it's easy for someone familiar with web technologies, but not for me; so I googled a bit and found a tutorial [here](https://kazuar.github.io/scraping-tutorial/).  
It gives step-by-step instructions on how to do get you login to bitbucket using Python.  
Well, there's not much difference in the case of logging in to Leetcode. I would assume anyone who tries to accomplish this task should be able to figure it out on there own.  
Here I am going to documented what to do after you logged in to your Leetcode.
## Step 1: See the list of all your submissions.
1. You can find a list of all your previous submissions on [https://leetcode.com/submissions/](https://leetcode.com/submissions/)  
![Leetcode Submission Page](/images/Leetcode-Scraper/Leetcode-submission-page.png)
It would probably take tens of pages (in my cases, 72) to show all your previous submissions.  
By appending page number to the URL, you can directly access those pages.   
Note that the URL [https://leetcode.com/submissions/](https://leetcode.com/submissions/) without any page number is equivalent to [https://leetcode.com/submissions/1/](https://leetcode.com/submissions/1/))  

2. We need a **page_count** variable to trace where we are at the submission page, and we will loop through all pages until the URL becomes invalid or no more submissions available.  
```python
page_count = 1
while True:
	# Test if we got error response code
	# Test if we got no more submissions available.
	
	# Extract code for each submission.
	page_count += 1
```
To test if we got error code, create the URL, send a GET request to server and check if the responsed status code is valid (200).
```python
result = session_requests.get(URL+str(page_count)+'/', headers = dict(referer = URL+str(page_count)+'/'))
if result.status_code != 200:   #Terminate if any wrong status is returned
	break
```  

3. Use similar technique as in the [Scraping Tutorial](https://kazuar.github.io/scraping-tutorial/), select the row of target submission and right click "inspect element" to see its source code.
![Leetcode Table Source Code](/images/Leetcode-Scraper/Leetcode-Table-SourceCode.png)
Each submission is a row in the talbe, so use `tree.findall()` to extract all of them.  
Here `contents` is a list, and when it's empty, we know there's no more submissions available.  
```python
tree = html.fromstring(result.content)
contents = tree.findall(".//table/tbody/tr")    #Each submission details is shown in a table row
if len(contents) == 0:
    break
```

## Step 2: Scrape code from each submission.
1. Now we could loop through each submission.  We want to organize all the code by problem since we could have multiple submissions to the same one. We also want only those **Accepted** code, and need to know which langauge a submission used.  
Therefore, we need to further extract the following info for each submission:
- Problem link: to get problem number and problem title.
- Code link: to get the submitted code.
- Status: to skip those wrong answer submissions.
- Extension: to save the code to the extension consistent to the language.  
```python
status = getLeafText(row[2])	#getLefText() is a recursive function that returns the text wrapped by nested tag.
problem_link = row[1][0].attrib['href']	
code_link = row[2][0].attrib['href']
extension = row[4].text
```
2. Skip invalid submissions and get problem title.  
```python
if status != 'Accepted':
    continue
#Get problem title, including its number
result = session_requests.get(BASE+problem_link, headers = dict(referer = BASE+problem_link))
tree = html.fromstring(result.content)      
title = tree.find(".//h3").text.strip()
```  
3. Your submitted code is stored in a JavaScript dictionary object name `pageData`.   
To get that, send a GET request with User-Agent header, and locate the script tag with `tree.xpath()` function.  
Note that the return string contains unicode escape characters so you need to add `.decode('unicode-escape')` to correctly decode it.  
```python
result = session_requests.get(BASE+code_link, headers = {"User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36"})
tree = html.fromstring(result.content)
codeScript = tree.xpath('//script[contains(., "pageData")]/text()')[0].decode('unicode-escape') #need to handle the uicode escape characters
```
4. Examine the returned `codeScript` string, you could locate the code part and substring it.
```python 
begin, end = codeScript.find('class Solution {'), codeScript.find('\',\n  editCodeUrl: ')   #locate the code part
codeStr = codeScript[begin:end] #substring the code part
```

## Step 3: Output to file:
This part is easy. Write a function that takes title, code, and extension as arguments and do file I/O for you. Here's my code. 
```python
def outputToFile(title, codeStr, extension, rootDir):
	currentDir = os.path.join(rootDir, title)	
	if not os.path.exists(currentDir):
		os.makedirs(currentDir) 
	count = 0
	for name in os.listdir(currentDir):
		if any(ext in name for ext in validExtension):
			count += 1
	fileName = title.replace(' ', '_')
	extension = 'py' if extension == 'python' else extension    #fix python extension. You might need to fix extension for other langauge.
	with open(currentDir+'/'+fileName+'_'+str(count+1)+'.'+extension, "w") as f:
		f.write(codeStr)
```
You can get the complete code on my GitHub repository [here](https://github.com/tyge318/LeetcodeToGit). Hope this short tutorial helps.  
<!--more-->

<div
	class="fb-like"
	data-share="true"
	data-width="450"
	data-show-faces="true">
</div>
<div class="fb-comments" data-href="https://tyge318.github.io/{{page.title}}/" data-numposts="10"></div>
