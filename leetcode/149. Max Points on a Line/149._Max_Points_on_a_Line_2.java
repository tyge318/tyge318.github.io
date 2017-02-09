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
    class Equation {
        double deltaX, deltaY;
        double rx, ry;
        public Equation(Point a, Point b) {
            this.rx = (double)a.x;
            this.ry = (double)a.y;
            this.deltaX = (double)b.x-(double)a.x;
            this.deltaY = (double)b.y-(double)a.y;
        }
        public boolean satisfy(Point p) {
            double leftSide = p.y-ry;
            if( deltaX == 0)
                return (p.x-rx == 0);
            double rightSide = (deltaY*(p.x-rx))/deltaX;
            return leftSide == rightSide;
        }
    }
    public int maxPoints(Point[] points) {
        HashMap<String, Integer> stat = new HashMap<String, Integer>();
        for(int i=0; i<points.length; i++) {
            String key = pointToString(points[i]);
            if( stat.containsKey(key) )
                stat.put(key, stat.get(key)+1 );
            else
                stat.put(key, 1);
        }
        //System.out.println("stat:" + stat.toString());
        List<String> data = new ArrayList<String>(stat.keySet() );
        if( data.isEmpty() )
            return 0;
        int max = stat.get(data.get(0));
        for(int i=0; i<data.size(); i++) {
            for(int j=i+1; j<data.size(); j++) {
                Point a = stringToPoint(data.get(i));
                Point b = stringToPoint(data.get(j));
                Equation eq = new Equation(a, b);
                int count = 0;
                for(int k=i; k<data.size(); k++) {
                    String current = data.get(k);
                    Point currentP = stringToPoint(current);
                    if( eq.satisfy(currentP) )
                        count += stat.get(current);
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
    public String pointToString(Point point) {
        return (String.valueOf(point.x)+","+String.valueOf(point.y));
    }
    public Point stringToPoint(String s) {
        String[] tokens = s.split(",");
        return (new Point(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]) ) );
    }
}