public class Solution {
    public int findMinArrowShots(int[][] points) {
        if( points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        //System.out.println("Points: " + Arrays.deepToString(points));
        Queue<int[]> live = new PriorityQueue<int[]>(points.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        live.add(points[0]);
        int index = 1, ans = 0;
        while( index != points.length) {
            if( live.isEmpty() || points[index][0] <= live.peek()[1]) {
                live.add(points[index]);
                index++;
            }
            else {
                ans++;
                live.clear();
            }
        }
        if( !live.isEmpty() )
            ans++;
        return ans;
    }
}