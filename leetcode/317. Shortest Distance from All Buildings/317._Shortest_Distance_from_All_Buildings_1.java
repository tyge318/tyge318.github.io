public class Solution {
    int m, n, ans;
    int[][] grid;
    int[][] distance;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = (m == 0) ? 0: grid[0].length;
        this.grid = grid;
        distance = new int[m][n];
        
        for(int i=0; i<m; i++) {
            distance[i] = grid[i].clone();
        }
        int mark = 0;  //use mark to trace visited cell
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] == 1) {
                    bfs(grid, distance, i, j, mark);
                    mark--; 
                }
            }
        }
        return ans;
    }
    public void bfs(int[][] grid, int[][] distance, int x, int y, int mark) {
        ans = -1;
        int[][] temp = new int[m][n];
        for(int i=0; i<m; i++)
            temp[i] = grid[i].clone();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while( !q.isEmpty()) {
            int[] current = q.poll();
            for(int k=0; k<4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];
                if( nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != mark) continue;
                grid[nx][ny]--; //mark as visited
                temp[nx][ny] = temp[current[0]][current[1]]+1;
                distance[nx][ny] += temp[nx][ny] - 1;   //initially grid[x][y] is 1, this needs to be take out.
                q.offer(new int[]{nx, ny});
                if( ans < 0 || distance[nx][ny] < ans )
                    ans = distance[nx][ny];
            }
        }
    }
}