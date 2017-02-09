public class Solution {
    int[][] matrix;
    int[][] opt;
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = ( m == 0) ? 0: matrix[0].length;
        opt = new int[m][n];
        this.matrix = matrix;
        
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans = Math.max(ans, findMaxPath(i, j) );
            }
        }
        return ans;
    }
    public int findMaxPath(int i, int j) {
        if( opt[i][j] != 0)
            return opt[i][j];
        for(int k=0; k<4; k++) {
            int x = i+dx[k];
            int y = j+dy[k];
            if( x >=0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y] )
            opt[i][j] = Math.max(opt[i][j], findMaxPath(x, y) );
        }
        opt[i][j]++;
        return opt[i][j];
    }
}