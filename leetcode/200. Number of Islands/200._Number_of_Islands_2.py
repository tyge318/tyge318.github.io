class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        
        ans = 0
        for i in xrange(m):
            for j in xrange(n):
                if grid[i][j] == '1':
                    self.walk(grid, i, j)
                    ans += 1
        return ans
    
    def walk(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':
            return;
        grid[i][j] = '0'    #mark as walked
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for l in directions:
            self.walk(grid, i+l[0], j+l[1])