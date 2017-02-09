Use hashmap to categorize words into their abbreviation.  
A word has unique abbreviation only if:  
a. Its abbreviation is not in the hashmap at all.  
b. The word itself is in the dictionary and is the only word of that abbreviation.  

Time Complexity: <span class="inlinecode">$O(n)$</span> in constructor (walk through each word) and <span class="inlinecode">$O(1)$</span> for the `isUnique())` function.