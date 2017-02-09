public class Solution {
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = (m == 0) ? 0 : matrix[0].length;

        List<int[]> ans = new ArrayList<int[]>();
        if( m == 0 || n == 0 )
            return ans;
        
        int[][] opt = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
                walk(matrix, opt, i, j);
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( opt[i][j] == 3)
                    ans.add(new int[]{i,j});
            }
        }
        return ans;
    }
    public void walk(int[][] matrix, int[][] opt, int i, int j) {
        if( i == 0 )
            opt[i][j] |= 1;
        if( i == m-1)
            opt[i][j] |= 2;
        if( j == 0 )
            opt[i][j] |= 1;
        if( j == n-1)
            opt[i][j] |= 2;
            
        for(int k=0; k<4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if( ni < 0 || ni >= m || nj < 0 || nj >= n)
                continue;
            if( matrix[i][j] <= matrix[ni][nj] && opt[i][j] != opt[ni][nj] ) {
                opt[ni][nj] |= opt[i][j];
                walk(matrix, opt, ni, nj);
            }
        }
    }
}