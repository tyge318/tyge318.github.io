This is the standard BFS problem: root is the gate, which has distance 0. Adjacent rooms to root are first level children, which have distance 1. Keep doing this until all rooms visited.  
Keep in mind that in expanding to children, rooms smaller than current room are either obstables (negative valued) or visited rooms so it is safe to just skip them.  
Time Complexity: $$O(n^2)$$