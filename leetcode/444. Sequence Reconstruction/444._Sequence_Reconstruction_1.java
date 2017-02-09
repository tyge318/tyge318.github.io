public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDeg = new HashMap<>();
        
        for(int[] seq: seqs) {
            if( seq.length == 1) {
                if( !graph.containsKey(seq[0]) ) {
                    graph.put(seq[0], new HashSet<>() );
                    inDeg.put(seq[0], 0);
                }
            }
            else {
                for(int i=1; i<seq.length; i++ ) {
                    if( !graph.containsKey(seq[i-1]) ) {
                        graph.put(seq[i-1], new HashSet<>() );
                        inDeg.put(seq[i-1], 0);
                    }
                    if( !graph.containsKey(seq[i]) ) {
                        graph.put(seq[i], new HashSet<>() );
                        inDeg.put(seq[i], 0);
                    }
                    if( graph.get(seq[i-1]).add(seq[i]) ) {
                        inDeg.put(seq[i], inDeg.get(seq[i])+1);
                    }
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDeg.entrySet()) {
            if( entry.getValue() == 0 )
                q.offer(entry.getKey() );
        }
        int index = 0;
        while( !q.isEmpty() ) {
            int size = q.size();
            if( size > 1)
                return false;
            int current = q.poll();
            if( index == org.length || current != org[index++] )
                return false;
            for(int next: graph.get(current) ) {
                inDeg.put(next, inDeg.get(next)-1);
                if( inDeg.get(next) == 0)
                    q.offer(next);
            }
        }
        return index == org.length && index == graph.size();
    }
}