public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] ans = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(i == 0 && j == 0) {
                    if( obstacleGrid[i][j] != 1)
                        ans[i][j] = 1;
                    else
                        ans[i][j] = 0;
                }
                else if( i == 0) {
                    if( obstacleGrid[i][j] != 1)
                        ans[i][j] = ans[i][j-1];
                    else
                        ans[i][j] = 0;
                }
                else if( j == 0) {
                    if( obstacleGrid[i][j] != 1)
                        ans[i][j] = ans[i-1][j];
                    else
                        ans[i][j] = 0;
                }
                else {
                    if( obstacleGrid[i][j] != 1)
                        ans[i][j] = ans[i][j-1] + ans[i-1][j];
                    else
                        ans[i][j] = 0;
                }
            }
        }
        return ans[row-1][col-1];
    }
}