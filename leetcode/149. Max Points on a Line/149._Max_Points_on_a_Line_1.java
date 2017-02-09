/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if( points.length == 0)
            return 0;
        if( points.length <= 2)
            return points.length;
        
        int ans = 0;
        for(int i=0; i<points.length; i++) {
            Map<Double, Integer> slopes = new HashMap<Double, Integer>();
            int sameX = 1;  //those that share the same x coordinate
            int sameP = 0;  //those that overlap
            for(int j=0; j<points.length; j++) {
                if( i == j)
                    continue;
                if( points[i].x == points[j].x && points[i].y == points[j].y ) 
                    sameP++;
                if( points[i].x == points[j].x) {
                    sameX++;
                    continue;
                }
                Double m = (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                if( slopes.containsKey(m) )
                    slopes.put(m, slopes.get(m)+1); //existing slope just needs add 1 point
                else
                    slopes.put(m, 2);   //new slope needs at least 2 points
                ans = Math.max(ans, slopes.get(m)+sameP);    //need to add overlapping points count
            }
            ans = Math.max(ans, sameX); //need to consider points on one vertical lines
        }
        return ans;
    }
}