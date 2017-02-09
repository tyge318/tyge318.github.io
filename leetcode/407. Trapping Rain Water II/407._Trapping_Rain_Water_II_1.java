public class Solution {
    int m, n;
    class Cell implements Comparable<Cell>{
        int x, y, height;
        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int trapRainWater(int[][] heightMap) {
        m = heightMap.length;
        n = (m == 0) ? 0: heightMap[0].length;
        
        if( heightMap == null || m <= 2 || n <= 2)
            return 0;
        
        boolean[][] visited = new boolean[m][n];
        
        Queue<Cell> pq = new PriorityQueue<Cell>();
        
        for(int i=0; i<n; i++) {
            pq.add( new Cell(0, i, heightMap[0][i]) );
            visited[0][i] = true;
            pq.add( new Cell(m-1, i, heightMap[m-1][i]) );
            visited[m-1][i] = true;
        }
        for(int i=0; i<m; i++) {
            pq.add( new Cell(i, 0, heightMap[i][0]) );
            visited[i][0] = true;
            pq.add( new Cell(i, n-1, heightMap[i][n-1]) );
            visited[i][n-1] = true;
        }
        
        int ans = 0;
        while( !pq.isEmpty()) {
            Cell current = pq.poll();
            for(int i=0; i<4; i++) {
                int nx = current.x+dx[i];
                int ny = current.y+dy[i];
                if( nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny])
                    continue;
                if( heightMap[nx][ny] < current.height) {   //make this cell the same hight as edge
                    ans += (current.height - heightMap[nx][ny]);
                    pq.add( new Cell(nx, ny, current.height) );
                }
                else
                    pq.add( new Cell(nx, ny, heightMap[nx][ny]) );    //it's already an edge    
                visited[nx][ny] = true;
            }
        }
        return ans;
    }
}