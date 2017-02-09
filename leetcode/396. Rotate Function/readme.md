Let's  walk through the example and see the pattern.  
`A = [4, 3, 2, 6]`  
Sum of the array, $$S_n  = 4 \cdot 1 + 3 \cdot 1 + 2 \cdot 1 + 6 \cdot 1 $$  
Weighted sum of the array, $$S_{wn} = 4 \cdot 0 + 3 \cdot 1 + 2 \cdot 2 + 6 \cdot 3 $$  
$$S_n + S_{wn} = 4 \cdot (1+0) + 3 \cdot (1+1) + 2 \cdot (1+2) + 6 \cdot (1+3) = F(1) + 6 \cdot (1+3) $$  
$$\Rightarrow F(1)  = S_n + S_{wn} - 4 \cdot 6 $$  
Now let's  let $$S_{wn} = F(1) $$  
$$\Rightarrow S_{wn} = 6 \cdot 0 + 4 \cdot 1 + 3 \cdot 2 + 2 \cdot 3  $$  
$$S_n + S_{wn} = 6 \cdot (1+0) + 4 \cdot (1+1) + 3 \cdot (1+2) + 2 \cdot (1+3) = F(2) + 2 \cdot (1+3) $$  
$$\Rightarrow F(2) = S_n + S_{wn} - 4 \cdot 2 $$  
...  
In general, we have:  
$$F(i) = S_n + F(i-1) - n \times a_{n-i}$$  
$$F(0) = S_{wn}$$  

Time Complexity: $$O(n)$$. 