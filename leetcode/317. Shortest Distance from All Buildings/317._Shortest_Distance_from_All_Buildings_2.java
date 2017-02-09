public class Solution {
    class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = (m == 0) ? 0: grid[0].length;
        int[][] total = new int[m][];
        for(int i=0; i<m; i++)
            total[i] = grid[i].clone();
        int mark = 0, ans = -1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] == 1) {
                    ans = -1;
                    int[][] temp = new int[m][];
                    for(int k=0; k<m; k++)
                        temp[k] = grid[i].clone();
                    Queue<Pair> q = new LinkedList<Pair>();
                    q.offer(new Pair(i, j) );
                    while( !q.isEmpty()) {
                        Pair current = q.poll();
                        for(int k=0; k<4; k++) {
                            int ni = current.x+dx[k];
                            int nj = current.y+dy[k];
                            if( ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] != mark )
                                continue;
                            grid[ni][nj]--;
                            temp[ni][nj] = temp[current.x][current.y]+1;
                            total[ni][nj] += temp[current.x][current.y];
                            q.offer(new Pair(ni, nj));
                            if( ans < 0 || ans > total[ni][nj])
                                ans = total[ni][nj];
                        }
                    }
                    mark--;
                }
            }
        }
        return ans;
    }
}