public class Solution {
    public List<String> summaryRanges(int[] nums) {
        TreeSet<Long> lefts = new TreeSet<Long>();
        TreeSet<Long> rights = new TreeSet<Long>();
        
        for(int i=0; i<nums.length; i++) {
            long current = (long)nums[i];
            if( lefts.contains(current+1) ) {
                lefts.remove(current+1);
                lefts.add(current);
            }
            else if( rights.contains(current-1) ) {
                rights.remove(current-1);
                rights.add(current);
            }
            else {
                lefts.add(current);
                rights.add(current);
            }
        }
        List<String> ans = new ArrayList<String>();
        Object[] begins = lefts.toArray();
        Object[] ends = rights.toArray();
        
        for(int i=0; i<begins.length; i++) {
            String begin = String.valueOf((Long)begins[i]);
            String end = String.valueOf((Long)ends[i]);
            if( begin.equals(end) )
                ans.add(begin );
            else
                ans.add(begin+ "->" + end );
        }
        return ans;
    }
}