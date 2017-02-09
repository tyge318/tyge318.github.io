#!/usr/bin/python
import os
import re

INPUT_DIR = os.path.join(os.getcwd(), 'leetcode')

def main():
	for subdir, dirs, files in os.walk(INPUT_DIR):
		for f in files:
			if '.md' not in f:
				continue
			title = os.path.basename(os.path.normpath(subdir))
			print 'Getting content for \"'+f+'\"...'
			content = ''
			
			with open(os.path.join(subdir, f), 'r') as contentFile:
				content += contentFile.read()
				
			re.search(r"\$\$.+?\$\$", content)