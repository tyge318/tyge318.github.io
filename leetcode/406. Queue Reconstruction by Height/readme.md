We could use the "k" value to insert each person to the right position.  
Sort people by h in reverse order.  
Sort people with the same h by k.  
Iterate through the sorted list and insert each person by k.  
Here's an example:  
After sorting: [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]   
Insertion:  
i = 0: [[7, 0]]  
i = 1: [[7, 0], [7, 1]]  
i = 2: [[7, 0], [6, 1], [7, 1]]  
i = 3: [[5, 0], [7, 0], [6, 1], [7, 1]]  
i = 4: [[5, 0], [7, 0], [5, 2], [6, 1], [7, 1]]  
i = 5: [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]  

Time Complexity: $$O(n\log n)$$