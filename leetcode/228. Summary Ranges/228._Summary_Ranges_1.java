public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if( nums.length < 1)    return ans;
        int begin = 0, end = begin+1;
        while( end < nums.length) {
            if( nums[end] - nums[end-1] == 1) {
                end++;
                continue;
            }
            addInterval(nums, begin, end-1, ans);
            begin = end;
            end = begin+1;
        }
        if( begin == nums.length-1)
            addInterval(nums, begin, begin, ans);
        else
            addInterval(nums, begin, end-1, ans);
        return ans;
    }
    public void addInterval(int[] nums, int i, int j, List<String> ans) {
        if( nums[j] == nums[i] )
            ans.add(String.valueOf(nums[i]));
        else
            ans.add(nums[i]+"->"+nums[j]);
    }
}