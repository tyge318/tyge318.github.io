We can use minHeap to solve this problem.

Here are some facts about water trapping:

1. Water needs to be trapped in a "pool", a cell whose height is relatively lower than its four adjacent cells.
2. Water always floods from the globally lowest cell.
3. "Edges" are the cell that assumed not be able to trap water.

And that's why minHeap is a great choice in solving this problem: the root node of a minHeap is gaurantee to be the global minimum.
We begin by allocating a 2D boolean matrix to track whether we've visited a cell or not. 
Next, add four boundaries of the matrix to the minHeap. Those are the cells that are gauranteed to be edges.
Iterate through these edges with our minHeap and check its four adjacent cells.
If the adjacent cell has height less than current cell, that's the pool cell. We bring water level to as high as the current (edge) cell, add to the sum the amount of water the pool cell traps, and then assume it to be an edge.
If the adjacent cell has height greater or equal to current cell, there's no way for the adjacent cell to trap water. Just record its height as it is.  
Remember to mark as visited after we check a cell.  
Time Complexity: Each cell is checked once plus the heapify cost so $$O(n)+O(n\log n) = O(n\log n)$$.