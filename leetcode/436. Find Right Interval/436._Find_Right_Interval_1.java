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
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i=0; i<intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        int[] ans = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            ans[i] = (key == null) ? -1: map.get(key);
        }
        return ans;
    }
}