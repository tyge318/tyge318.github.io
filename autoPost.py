import os
import re

INPUT_DIR = os.path.join(os.getcwd(), 'leetcode')
OUTPUT_DIR = '_pages/leetcodes/_posts/'

def main():
	for subdir, dirs, files in os.walk(INPUT_DIR):
		for f in files:
			if '.md' not in f:
				continue
			title = os.path.basename(os.path.normpath(subdir))
			print 'Getting content for \"'+f+'\"...'
			content = "---\nlayout: leetcode\n"
			content += ('title: ' + title + '\n')
			content += 'categories: leetcode\nexcerpt_separator: <!--more-->\n---\n'
			
			with open(os.path.join(subdir, f), 'r') as contentFile:
				content += contentFile.read()	
			content += '\n<!--more-->\n'
			hasCode = False
			for code in os.listdir(subdir):
				if '.md' in code:
					continue
				elif '.java' in code:
					content += '### Java Code:\n{% highlight java linenos %}\n'
				elif '.cpp' in code:
					content += '### C++ Code:\n{% highlight cpp linenos %}\n'
				elif '.py' in code:
					content += '### Python Code:\n{% highlight python linenos %}\n'
				else:
					continue
				hasCode = True
				print 'Fetching code file \"'+code+'\"...'
				with open(os.path.join(subdir, code), 'r') as codeFile:
					content += codeFile.read()
				content += '\n{% endhighlight %}\n'
			if hasCode:
				outputPostMD(content, title)
			
def outputPostMD(content, title):
	fileName = '2016-09-29-'+title+'.md'
	fileName = os.path.join(OUTPUT_DIR, fileName)
	print 'Generating file \"' + fileName + '\"...'
	with open(fileName, 'w') as f:
		f.write(content)
				
if __name__ == '__main__':
	main()