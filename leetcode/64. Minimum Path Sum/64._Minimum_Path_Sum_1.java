public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] ans = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(i==0 && j==0) {
                    ans[i][j] = grid[0][0];
                }
                else if(i==0 ) {
                    ans[i][j] = ans[i][j-1] + grid[i][j];
                }
                else if(j==0 ) {
                    ans[i][j] = ans[i-1][j] + grid[i][j];
                }
                else {
                    ans[i][j] = grid[i][j] + Math.min(ans[i-1][j], ans[i][j-1]);
                }
            }
        }
        return ans[row-1][col-1];
    }
}