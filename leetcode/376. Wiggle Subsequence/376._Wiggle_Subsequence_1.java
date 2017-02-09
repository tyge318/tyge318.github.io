public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if( nums == null )  return 0;
        if( nums.length <= 1 )  return nums.length;
        List<Integer> diffs = new ArrayList<Integer>();
        for(int i=1; i<nums.length; i++) {
            if( nums[i] == nums[i-1])
                continue;
            diffs.add(nums[i]-nums[i-1]);
        }
        if( diffs.size() <= 1)  return 1;
        int count = 1, last = diffs.get(0);
        for(int i=1; i<diffs.size(); i++) {
            if( diffs.get(i) * last < 0 )
                count++;
            last = diffs.get(i);
        }
        return count+1;
    }
}