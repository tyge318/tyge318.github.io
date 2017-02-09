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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<Interval>();
        if( intervals.isEmpty() ) {
            ans.add(newInterval);
            return ans;
        }
        int targetBegin = newInterval.start;
        int targetEnd = newInterval.end;
        int begin = targetBegin, end = targetEnd;
        boolean flag1 = false, flag2 = true;
        for(int i=0; i<intervals.size(); i++) {
            int curBegin = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            if( curEnd < targetBegin || curBegin > targetEnd) {
                if(flag1) {
                    ans.add( new Interval(begin, end));
                    flag1 = false;
                    flag2 = false;
                }
                ans.add(intervals.get(i) );
            }
            else {
                begin = Math.min(begin, curBegin);
                end = Math.max(end, curEnd);
                flag1 = true;
            }
        }
        if(flag2) {
            if( !ans.isEmpty() )
                ans.add( getIndex(ans, 0, ans.size()-1, begin) , new Interval(begin, end) );
            else
                ans.add(new Interval(begin, end));
        }
        return ans;
    }
    public int getIndex(List<Interval> list, int begin, int end, int target) {
        if(begin == end) {
            if( list.get(begin).start > target)
                return begin;
            else
                return begin+1;
        }
        int mid = (begin+end)/2;
        if( list.get(mid).start > target) { //on the left
            return getIndex(list, begin, Math.max(begin, mid-1), target);
        }
        else { //on the right
            return getIndex(list, Math.min(mid+1, end), end, target);
        }
    }
}