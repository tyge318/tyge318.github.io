For each row, scan left to right and count the number of enemies on the left for each empty cell. Scan backwords to count the number of enemies on the right for each empty cell. Remember to reset count to 0 whenever encountering a wall.
Do the same (top to bottom and bottom to top) for each column.  
Then perform `max()` operation to find the global maximum, which is the answer.  
Time Complexity: $$O(mn)$$