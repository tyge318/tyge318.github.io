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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });
        Queue<Interval> live = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.end, b.end);
            } 
        });
        live.add(intervals[0]);
        int index = 1, ans = 1;
        while( index != intervals.length ) {
            if( live.isEmpty() ) {
                live.add(intervals[index]);
                index++;
            }
            else if( intervals[index].start < live.peek().end ) {    //there's an overlap
                live.add(intervals[index]);
                index++;
                ans = Math.max(ans, live.size());
            }
            else {
                live.poll();
            }
        }
        return ans;
    }
}