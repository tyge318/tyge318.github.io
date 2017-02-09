public class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = ( m == 0) ? 0: matrix[0].length;

        int ans = 0;
        int[][] opt = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans = Math.max(ans, countPath(matrix, opt, i, j));
            }
        }
        return ans;
    }
    public int countPath(int[][] matrix, int[][] opt, int i, int j) {
        if( opt[i][j] != 0) return opt[i][j];
        for(int k=0; k<4; k++) {
            int nx = i+dx[k], ny = j+dy[k];
            if( nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] <= matrix[i][j])   continue;
            opt[i][j] = Math.max(opt[i][j], countPath(matrix, opt, nx, ny) );
        }
        opt[i][j]++;
        return opt[i][j];
    }
}