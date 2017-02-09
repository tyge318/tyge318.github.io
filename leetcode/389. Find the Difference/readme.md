Bitwise XOR comes to rescue. 
1 XOR 0 = 0 XOR 1 = 1  
1 XOR 1 = 0 XOR 0 = 0  
Thus, $$x$$ XOR $$x$$ = 0.  
Simply XOR all char in `s` and `t` and each duplicated letter will pair up and cancel with each other.
The remaining is the ASCII value for the different char.  

Time Complexity: $$O(n)$$