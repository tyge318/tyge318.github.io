/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if( node == null )
            return null;
        Map<Integer, UndirectedGraphNode> dict = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode copy = clone(node, dict);
        return copy;
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> dict) {
        UndirectedGraphNode copy = (dict.containsKey(node.label)) ? dict.get(node.label) : (new UndirectedGraphNode(node.label) );
        for(UndirectedGraphNode e: node.neighbors) {
            if( node.label == e.label)
                copy.neighbors.add( copy );
            else if( dict.containsKey(e.label) )
                copy.neighbors.add( dict.get(e.label) );
            else
                copy.neighbors.add( clone(e, dict) );
        }
        dict.put(node.label, copy);
        return copy;
    }
}