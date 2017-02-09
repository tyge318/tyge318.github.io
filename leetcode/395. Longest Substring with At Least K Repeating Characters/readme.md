Since `s` contains only 26 lowercase letters, use an int array `count` to store the char occurrence of each letter. This will be used to check whether a substring satisfies the condition.   
We need a `valid()` function to do the checking. A substring `count[]` array is valid when:  
1. There are some letters that never show in the substring, which we don't care.  
2. Otherwise, it must appear at least `k` times.  
Note that we will need to keep tracking how many **dont-care** chars we have. Remember we have only 26 letters to choose from; so we can't have 26 **dont-care** letters as it simply implies that the substring is empty.  

Use variable `i` as the substring begin index and `j` as the substring end index. `i` goes from 0 up to $$n$$ and `j` goes from $$n-1$$ down to 0. Iteratively decrement the letter count of position i, j and record the substring length that meets the condition to get the global maximum.   
Time Complexity: $$O(n^2)$$. 