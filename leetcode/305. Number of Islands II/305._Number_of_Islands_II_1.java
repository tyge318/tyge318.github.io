public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if( m == 0 || n == 0)   return ans;
        
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        int count = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int[] p: positions) {
            int id = p[0]*n + p[1];
            roots[id] = id; //assume it's new island
            count++;
            
            for(int k=0; k<4; k++) {
                int nx = p[0]+dx[k], ny = p[1]+dy[k];
                int nextId = nx*n+ny;
                if( nx < 0 || nx >= m || ny < 0 || ny >= n || roots[nextId] == -1)
                    continue;
                int rootNext = findRoot(roots, nextId);
                if( rootNext != id) {   //neighbor should have the same id => union
                    roots[id] = rootNext;
                    id = rootNext;
                    count--;
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public int findRoot(int[] roots, int id) {
        while( id != roots[id] ) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}