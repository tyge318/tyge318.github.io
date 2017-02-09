public class Solution {
    public int maxProduct(int[] nums) {
        int maxOpt, minOpt, max = nums[0];
        maxOpt = minOpt = nums[0];
        for(int i=1; i<nums.length; i++) {
            int hold = maxOpt;
            maxOpt = Math.max(nums[i], Math.max(nums[i]*minOpt, nums[i]*maxOpt));
            minOpt = Math.min(nums[i], Math.min(nums[i]*minOpt, nums[i]*hold));
            max = Math.max(max, maxOpt);
        }
        return max;
    }
}