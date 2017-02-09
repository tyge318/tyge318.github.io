Try to fit the chunk of **sentence string** (space joined sentence with an extra space at the end) to each row.  
The **sentence string** chunk is the **maximum lengthed partial sentence string without cutted word**.  
The trick is, use `pos % len` to test if next row starts with a space. If so, then the space can be elinimated so we need to increase `pos`. Otherwise, there's a word cut and we need to decrease `pos` until we meet a space, so that the next word can be completely displayed on the next row.  
Time Complexity: $$O(m*n)$$ where $$m$$ is number of row and **n** is the maxmimum word length in the sentence.  

The execution tiime of the `while` loop all depends on the length of each word in the sentence. Thus, it can be pre-computed outside the loop, and the time complexity will be reduced to $$O(m+n)$$.  