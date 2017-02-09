/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            } 
        });
        if( intervals.size() < 1 )  return ans;
        Interval prevI = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval curI = intervals.get(i);
            if( curI.start <= prevI.end ) {
                prevI = new Interval(prevI.start, Math.max(prevI.end, curI.end));
                continue;
            }
            ans.add(prevI);
            prevI = curI;
        }
        ans.add(prevI);
        return ans;
    }
}