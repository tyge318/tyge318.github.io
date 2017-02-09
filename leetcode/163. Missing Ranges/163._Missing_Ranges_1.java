public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if( n == 0 ) {
            addInterval(ans, lower, upper);
            return ans;
        }
        if( (long)nums[0] - (long)lower >= 1)
            addInterval(ans, lower, nums[0]-1);
        for(int i=1; i<n; i++) {
            if((long)nums[i] - (long)nums[i-1] > 1)
                addInterval(ans, nums[i-1]+1, nums[i]-1);
        }
        if( (long)upper - (long)nums[n-1] >= 1)
            addInterval(ans, nums[n-1]+1, upper);
        return ans;
    }
    public void addInterval(List<String> ans, int begin, int end) {
        if( begin == end)
            ans.add(String.valueOf(begin) );
        else
            ans.add(String.valueOf(begin)+"->"+String.valueOf(end));
    }
}