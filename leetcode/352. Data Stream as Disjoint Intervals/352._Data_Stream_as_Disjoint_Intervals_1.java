/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    private TreeSet<Interval> data;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        data = new TreeSet<Interval>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return (new Integer(a.start)).compareTo(b.start);
            }
        });
    }
    
    public void addNum(int val) {
        Interval target = new Interval(val, val);
        
        Interval floor = data.floor(target);
        if( floor != null) {
            if( floor.end >= val)
                return;
            else if (floor.end+1 == val) {
                target.start = floor.start;
                data.remove(floor);
            }
        }
        
        Interval ceiling = data.higher(target);
        if( ceiling != null && ceiling.start == val+1) {
            target.end = ceiling.end;
            data.remove(ceiling);
        }
        data.add(target);
    }
    
    public List<Interval> getIntervals() {
        return Arrays.asList(data.toArray(new Interval[0]) );
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */