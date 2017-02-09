public class Solution {
        class Node implements Comparable<Node> {
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
            return this.val+"("+this.inDegree+")";
        }
        @Override
        public int compareTo(Node other) {
            return (new Integer(this.inDegree)).compareTo(other.inDegree);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodes = new HashMap<Integer, Node>();
        List<Integer> courses = new ArrayList<Integer>();
        for(int i=0; i<numCourses; i++)
            courses.add(i);
        for(int i=0; i<prerequisites.length; i++) {
            int to = prerequisites[i][0], from = prerequisites[i][1];
            Node fromNode = (nodes.containsKey(from)) ? nodes.get(from) : (new Node(from));
            Node toNode = (nodes.containsKey(to)) ? nodes.get(to) : (new Node(to));
            fromNode.addNext(toNode);
            toNode.addPrev(fromNode);
            nodes.put(from, fromNode);
            nodes.put(to, toNode);
        }
        
        LinkedList<Integer> trace = new LinkedList<Integer>();
        PriorityQueue<Node> q = new PriorityQueue<Node>(nodes.values());
        //System.out.println("q = " + q.toString());
        //Collections.sort(q);
        
        while( !q.isEmpty() ) {
            Node current = q.poll();
            trace.add(current.val);
            if( current.inDegree != 0 )  {
                return (new int[0]);
            }
            for(Node next: current.nexts) {
                q.remove(next);
                next.inDegree--;
                q.add(next);
            }
            //Collections.sort(q);
            //System.out.println("q = " + q.toString());
        }
        courses.removeAll(trace);
        for(int i=0; i<courses.size(); i++) {
            trace.add(0, courses.get(i));
        }
        int[] ans = new int[numCourses];
        for(int i=0; i<ans.length; i++)
            ans[i] = trace.get(i);
        return ans;
    }
}