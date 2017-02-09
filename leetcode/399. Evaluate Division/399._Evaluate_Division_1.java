public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> indices = new HashMap<String, Integer>();
        for(int i=0; i<equations.length; i++) {
            if( !indices.containsKey(equations[i][0]) )
                indices.put(equations[i][0], indices.size());
            if( !indices.containsKey(equations[i][1]) )
                indices.put(equations[i][1], indices.size());
        }
        int n = indices.size();
        double[][] graph = new double[n][n];
        
        for(int i=0; i<equations.length; i++) {
            int begin = indices.get(equations[i][0]);
            int end = indices.get(equations[i][1]);
            double forward = values[i], backward = (1.0/values[i]);
            graph[begin][end] = forward;
            graph[end][begin] = backward;
        }
        
        for(int i=0; i<n; i++) {
            graph[i][i] = 1.0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if( graph[j][i] != 0 && graph[i][k] != 0) {
                        graph[j][k] = graph[j][i] * graph[i][k];
                    }
                }
            }
        }
        double[] ans = new double[queries.length];
        for(int i=0; i<queries.length; i++) {
            int begin = indices.containsKey(queries[i][0]) ? indices.get(queries[i][0]) : -1;
            int end = indices.containsKey(queries[i][1]) ? indices.get(queries[i][1]) : -1;
            if( begin == -1 || end == -1 || graph[begin][end] == 0)
                ans[i] = -1;
            else
                ans[i] = graph[begin][end];
        }
        return ans;
    }
}