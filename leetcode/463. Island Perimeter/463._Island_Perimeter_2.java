public class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = (m == 0) ? 0: grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] == 0)    continue;
                for(int k=0; k<4; k++) {
                    int ti = i+dx[k], tj = j+dy[k];
                    if( ti < 0 || ti >= m || grid[ti][j] == 0 )
                        ans++;
                    if( tj < 0 || tj >= n || grid[i][tj] == 0 )
                        ans++;
                }
            }
        }
        return ans;
    }
}