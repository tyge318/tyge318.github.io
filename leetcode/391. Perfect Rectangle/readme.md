Let's say n rectangles formed a bounding rectangle. The key to solve this problem is to figure out the fact that n rectangles form a perfect rectangle if:  
1. The sum of n rectangle area is equal to the area of the bounding rectangle.
2. Except for the 4 vertices of the bounding rectangle, every other vertices are considered to be **internal** and they should appear **in pairs**.

Therefore, loop through each rectangle.  
Use extreme value function to find the 4 vertices of the bounding rectangle.  
Use `set` data structure to pair up vertices.  
Accumulate each rectangle's area.  
After the loop, check if the 2 conditions listed above are met.  

Time Complexity: $$O(n)$$