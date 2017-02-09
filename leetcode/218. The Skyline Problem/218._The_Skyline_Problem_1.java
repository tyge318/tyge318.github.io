public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>();
        List<int[]> q = new LinkedList<int[]>();
        
        for(int[] building: buildings) {
            int[] begin = {building[0],-building[2]};
            int[] end = {building[1], building[2]};
            q.add(begin);
            q.add(end);
        }
        Collections.sort(q, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if( a[0] == b[0])
                    return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            } 
        });
        Queue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -a.compareTo(b);
            } 
        });
        heap.offer(0);
        int prev = 0;
        for(int[] edge: q) {
            if( edge[1] < 0 )
                heap.offer(-edge[1]);
            else
                heap.remove(new Integer(edge[1]));
            int current = heap.peek();
            if(prev != current) {
                ans.add(new int[]{edge[0], current});
                prev = current;
            }
        }
        return ans;
    }
}