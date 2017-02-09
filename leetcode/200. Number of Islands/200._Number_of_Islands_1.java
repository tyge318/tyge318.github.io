public class Solution {
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = (m == 0) ? 0: grid[0].length;
        if( m == 0 || n == 0)   return 0;
        
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    ans++;   
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while( !q.isEmpty()) {
            int[] current = q.poll();
            for(int k=0; k<4; k++) {
                int nx = current[0]+dx[k], ny = current[1]+dy[k];
                if( nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != '1' || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}