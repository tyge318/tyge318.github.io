The key is to **pair up each character**. 
Palindrome can have at most 1 odd-count character.  
Here we use a `Set` data structure.  
Loop through each character of the string.  
If a character isn't in the set, it must be the odd (1st, 3rd, 5th, ...) time we see it. Then we add it to the set.  
Otherwise, it must be the even (2nd, 4th, 6th, ...) time we see it. Then we remove it from the set and add 2 to the answer.  
After the loop, the set contains all characters whose occurrence is an odd number.  
If the set is empty, it means each character of `s` appears even number of times; we just return the answer.  
Otherwise, we can only choose 1 from the set (as the middle character); return answer + 1.  
Time Complexity: $$O(n)$$. 