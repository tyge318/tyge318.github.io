public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i=0; i<n; i++)
            roots[i] = i;
        
        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            int ra = findRoot(roots, a);
            int rb = findRoot(roots, b);
            if( ra != rb ) {
                roots[rb] = ra;
                n--;
            }
        }
        return n;
    }
    public int findRoot(int[] roots, int id) {
        while( id != -1 && id != roots[id] ) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}