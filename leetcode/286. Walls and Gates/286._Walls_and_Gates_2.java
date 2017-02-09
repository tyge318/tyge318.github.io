public class Solution {
    int[][] rooms;
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        m = rooms.length;
        n = (m == 0) ? 0: rooms[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( rooms[i][j] == 0 ) {
                    for(int k=0; k<4; k++) {
                        dfs(i+dx[k], j+dy[k], 1);
                    }
                }
            }
        }
    }
    public void dfs(int row, int col, int val) {
        if( row < 0 || row >= m || col < 0 || col >= n || rooms[row][col] == -1)
            return;
        if( val < rooms[row][col]) {
            rooms[row][col] = val;
            for(int i=0; i<4; i++)
                dfs(row+dx[i], col+dy[i], val+1);
        }
    }
}