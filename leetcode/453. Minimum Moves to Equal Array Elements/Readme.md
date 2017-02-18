Here's what happens when a move is performed:  
$$a_0+1, a_1+1, ... a_i, a_{i+1}+1, ..., a_n+1$$  
Subtract one from every term:  
$$a_0, a_1, ..., a_i-1, a_{i+1}, ..., a_n$$  
So a move of incrementing $$n-1$$ elements is equivalent to that of decrementing **one** element.  
To get the minimum number of moves, just find out the minimum one and decrement all other terms until they all reach minimum.  
Time Complexity: $$O(n)$$.