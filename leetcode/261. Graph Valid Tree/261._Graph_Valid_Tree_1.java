public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if( edges.length != n-1)
            return false;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<Integer>());
        for(int[] edge: edges) {
            if( edge[0] >= n || edge[1] >= n)
                return false;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        if( isTree(visited, graph, -1, 0) )
            return false;
        for(boolean k: visited)
            if( !k )
                return false;
        return true;
    }
    public boolean isTree(boolean[] visited, List<List<Integer>> graph, int parent, int current) {
        visited[current] = true;
        for(Integer next: graph.get(current) ) {
            if( (visited[next] && parent != next) || (!visited[next] && isTree(visited, graph, current, next) ) )
                return true;
        }
        return false;
    }
}