public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if( rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length;
        int n = (m == 0) ? 0: rooms[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if( rooms[i][j] == 0)
                    q.add(new int[]{i, j});
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while( !q.isEmpty() ) {
            int[] current = q.poll();
            int currentVal = rooms[current[0]][current[1]];
            for(int i=0; i<4; i++) {
                int[] next = {current[0]+dx[i], current[1]+dy[i]};
                if( next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n )
                    continue;
                if( rooms[next[0]][next[1]] <= currentVal+1 )
                    continue;
                q.add(next);
                rooms[next[0]][next[1]] = currentVal+1;
            }
        }
    }
}