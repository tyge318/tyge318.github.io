public class Solution {
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = (m == 0) ? 0 : grid[0].length;
        if( m == 0) return 0;
        int[][] mark = new int[m][n];
        
        int id = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( mark[i][j] == 0 && grid[i][j] == '1')
                    extend(mark, grid, i, j, id++);
            }
        }
        return (id-1);
    }
    public void extend(int[][] mark, char[][] grid, int row, int col, int id) {
        if( row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != '1' || mark[row][col] != 0)
            return;
        mark[row][col] = id;
        for(int i=0; i<4; i++) {
            extend(mark, grid, row+dx[i], col+dy[i], id);
        }
    }
}