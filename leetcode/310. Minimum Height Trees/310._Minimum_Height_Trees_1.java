import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<n; i++)
            graph.put(i, new ArrayList<Integer>() );
        for(int[] edge: edges) {
            int A = edge[0];
            int B = edge[1];
            graph.get(A).add(B);
            graph.get(B).add(A);
        }
		//System.out.println(graph);
		while(graph.size() > 2) {
			ArrayList<Integer> toBeRemoved = new ArrayList<Integer>();
			Iterator iter = graph.entrySet().iterator();
			while(iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				int key = (int)entry.getKey();
				ArrayList<Integer> val = (ArrayList<Integer>)entry.getValue();
				if(val.size() <= 1) {
					toBeRemoved.add(key);
					iter.remove();
				}
			}
			for(Integer key: graph.keySet()) {
				graph.get(key).removeAll(toBeRemoved);
			}
		}
		//System.out.println(graph);
		ArrayList<Integer> output = new ArrayList<Integer>(graph.keySet());
		return output;
    }
}