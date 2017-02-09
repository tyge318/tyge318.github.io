public class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m, n;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = (m == 0) ? 0: matrix[0].length;
        int[][] opt = new int[m][n];
        List<int[]> ans = new ArrayList<>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dfs(matrix, opt, i, j);
            }
        }
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if( opt[i][j] == 3) ans.add(new int[]{i, j});
        return ans;
    }
    public void dfs(int[][] matrix, int[][] opt, int x, int y) {
        if( x == 0 || y == 0)    opt[x][y] |= 1;
        if( x == m-1 || y == n-1 )  opt[x][y] |= 2;
        
        for(int k=0; k<4; k++) {
            int nx = x+dx[k], ny = y+dy[k];
            if( nx < 0 || nx >= m || ny < 0 || ny >= n )    continue;
            if( matrix[nx][ny] >= matrix[x][y] && opt[nx][ny] != opt[x][y]) {
                opt[nx][ny] |= opt[x][y];
                dfs(matrix, opt, nx, ny);
            }
        }
    }
}