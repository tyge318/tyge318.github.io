We are going to concatenate/join all strings in the list, but as there could be empty strings, we need to also keep the string length.  
Each string will be in **length@str** format. The length info could be use to decide string boundary.  
In decoding, we could use the `indexOf()` function which find the first index of the arg string. And we have the length info to get the first string (also cut the first string from the remaining ones).  
Keep doing so until no more string left in the encoded string.  
Time Complexity: $$O(n)$$