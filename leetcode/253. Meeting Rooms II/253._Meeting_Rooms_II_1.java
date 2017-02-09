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
        if( intervals.length == 0)  return 0;
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i=0; i<n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int ans = 0, endIndex = 0;
        for(int i=0; i<n; i++) {
            if( starts[i] < ends[endIndex])
                ans++;
            else
                endIndex++;
        }
        return ans;
    }
}