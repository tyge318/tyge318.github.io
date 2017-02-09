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
        List<Interval> ans = new ArrayList<Interval>();
        Comparator<Interval> c = new Comparator<Interval>() {
            public int compare(Interval obj1, Interval obj2){
                Integer o1start = new Integer(obj1.start);
                Integer o2start = new Integer(obj2.start);
                return o1start.compareTo(o2start);
            }
        };
        Collections.sort(intervals, c);

        int begin = 0, end = 0;
        if( !intervals.isEmpty()) {
            begin = intervals.get(0).start;
            end = intervals.get(0).end;
        }
        else
            return ans;
        for(int i=1; i<intervals.size(); i++) {
            int curBegin = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            if(curBegin <= end)
                end = Math.max(end, curEnd);
            else {
                ans.add(new Interval(begin, end) );
                begin = curBegin;
                end = curEnd;
            }
        }
        ans.add( new Interval(begin, end));
        return ans;
    }
}