Playing with math again.  
The key is to find out the begin value of next iteration.  
Use counter to track the direction. If counter is odd, the direction is from small to large number. Otherwise it's the opposite direction.  
At each iteration, double the step (`d` in my code) and divide n by 2.  
Note that at each iteration, the different between begin and the first step is half of current step.
 
Time Complexity: $$O(\log n)$$