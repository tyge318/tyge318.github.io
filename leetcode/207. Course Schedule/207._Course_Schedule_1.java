public class Solution {
    class Node {
        int val;
        Set<Node> nexts;
        Set<Node> prevs;
        int inDegree;
        public Node(int val) {
            this.val = val;
            nexts = new HashSet<Node>();
            prevs = new HashSet<Node>();
        }
        public void addNext(Node next) {
            nexts.add(next);
        }
        public void addPrev(Node prev) {
            prevs.add(prev);
            inDegree = prevs.size();
        }
        public boolean equals(Node other) {
            return (this.val == other.val);
        }
        public String toString() {
            return String.valueOf(val);
        }
    }
    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return (new Integer(n1.inDegree)).compareTo(n2.inDegree);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodes = new HashMap<Integer, Node>();
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][0], to = prerequisites[i][1];
            Node fromNode = (nodes.containsKey(from)) ? nodes.get(from) : (new Node(from));
            Node toNode = (nodes.containsKey(to)) ? nodes.get(to) : (new Node(to));
            fromNode.addNext(toNode);
            toNode.addPrev(fromNode);
            nodes.put(from, fromNode);
            nodes.put(to, toNode);
        }
        
        List<Integer> trace = new ArrayList<Integer>();
        LinkedList<Node> q = new LinkedList<Node>(nodes.values());
        Collections.sort(q, new NodeComparator());
        //System.out.println("content: "+q.toString());
        
        while( !q.isEmpty() ) {
            Node current = q.poll();
            trace.add(current.val);
            //numCourses--;
            if( current.inDegree != 0 )  {
                return false;
            }
            for(Node next: current.nexts) {
                next.inDegree--;
            }
            Collections.sort(q, new NodeComparator());
            //System.out.println("content: "+q.toString());
        }
        //System.out.println(trace.toString());
        return true;
    }
}