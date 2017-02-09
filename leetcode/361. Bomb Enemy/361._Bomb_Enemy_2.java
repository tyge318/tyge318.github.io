public class Solution {
    int m, n;
    public int maxKilledEnemies(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = (m == 0) ? 0: grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] == '0')
                    ans = Math.max(ans, countEnemy(grid, i, j, true)+countEnemy(grid, i, j, false) );
            }
        }
        return ans;
    }
    public int countEnemy(char[][] grid, int row, int col, boolean isRow) {
        int k, ans = 0;
        if( isRow ) {
            //col to right
            k = col;
            while( k<n && grid[row][k] != 'W') {
                if( grid[row][k] == 'E')
                    ans++;
                k++;
            }
            //col to left
            k = col;
            while( k >= 0 && grid[row][k] != 'W') {
                if( grid[row][k] == 'E')
                    ans++;
                k--;
            }
            return ans;
        }
        else {
            //row to top
            k = row;
            while( k >= 0 && grid[k][col] != 'W') {
                if( grid[k][col] == 'E')
                    ans++;
                k--;
            }
            //row to bottom
            k = row;
            while( k < m && grid[k][col] != 'W') {
                if( grid[k][col] == 'E')
                    ans++;
                k++;
            }
            return ans;
        }
    }
}