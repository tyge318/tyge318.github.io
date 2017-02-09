public class Solution {
    int n;
    public boolean isConvex(List<List<Integer>> points) {
        n = points.size();
        int flag = 0;
        for(int i=0; i<n; i++) {
            int temp = orientation(points, i);
            if( temp == 0)  continue;
            if( flag == 0)
                flag = (temp > 0) ? 1: -1;
            else if( flag > 0 != temp > 0 )
                return false;
        }
        return true;
    }
    public int orientation(List<List<Integer>> points, int i) {
        List<Integer> a = points.get(i % n);
        List<Integer> b = points.get((i+1) % n);
        List<Integer> c = points.get((i+2) % n);
        return ((b.get(1)-c.get(1))*(a.get(0)-b.get(0)) - (a.get(1)-b.get(1))*(b.get(0)-c.get(0)));
    }
}