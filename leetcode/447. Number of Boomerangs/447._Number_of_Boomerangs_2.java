public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int[] a: points) {
            Map<Integer, Integer> trace = new HashMap<Integer, Integer>();
            for(int[] b: points) {
                int dis = distance(a, b);
                if( !trace.containsKey(dis) )
                    trace.put(dis, 0);
                ans += trace.get(dis);
                trace.put(dis, trace.get(dis)+2);
            }
        }
        return ans;
    }
    public int distance(int[] a, int[] b) {
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}