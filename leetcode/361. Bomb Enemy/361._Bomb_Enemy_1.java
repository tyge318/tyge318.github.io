public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = (m == 0) ? 0: grid[0].length;
        
        int[][] opt = new int[m][n];
        int ans = 0;
        for(int i=0; i<m; i++) {
            int rowCount = 0;
            for(int j=0; j<n; j++) {
                if( grid[i][j] == '0')  opt[i][j] += rowCount;
                else if( grid[i][j] == 'E') rowCount++;
                else    rowCount = 0;
            }
            rowCount = 0;
            for(int j=n-1; j>=0; j--) {
                if( grid[i][j] == '0')  opt[i][j] += rowCount;
                else if( grid[i][j] == 'E') rowCount++;
                else    rowCount = 0;
            }
        }
        
        for(int j=0; j<n; j++) {
            int colCount = 0;
            for(int i=0; i<m; i++) {
                if( grid[i][j] == '0')  opt[i][j] += colCount;
                else if( grid[i][j] == 'E') colCount++;
                else    colCount = 0;
            }
            colCount = 0;
            for(int i=m-1; i>=0; i--) {
                if( grid[i][j] == '0')  {
                    opt[i][j] += colCount;
                    ans = Math.max(ans, opt[i][j]);
                }
                else if( grid[i][j] == 'E') colCount++;
                else    colCount = 0;
            }
        }
        return ans;
    }
}