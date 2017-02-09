public class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        if( m <= 0 || n <= 0)  
            return ans;
        int count = 0;
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        
        for(int[] p: positions) {
            int id = n*p[0]+p[1];
            roots[id] = id;
            count++;
            for(int i=0; i<4; i++) {
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
                int neighbor = n*nx + ny;
                if( nx < 0 || nx >= m || ny < 0 || ny >= n || roots[neighbor] == -1)
                    continue;
                
                int rootNeighbor = findRoot(roots, neighbor);
                if( id != rootNeighbor ) { //union
                    roots[id] = rootNeighbor;
                    id = rootNeighbor;
                    count--;
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public int findRoot(int[] roots, int id) {
        while( id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}