public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> trace = new ArrayList<Integer>();
        trace.add(1);
        
        int i2, i3, i5;
        i2 = i3 = i5 = 0;
        while( trace.size() < n) {
            int m2 = trace.get(i2)*2;
            int m3 = trace.get(i3)*3;
            int m5 = trace.get(i5)*5;
            int current = Math.min(m2, Math.min(m3, m5));
            if( current == m2)
                i2++;
            if( current == m3)
                i3++;
            if( current == m5)
                i5++;
            trace.add(current);
        }
        return trace.get(trace.size()-1);
    }
}