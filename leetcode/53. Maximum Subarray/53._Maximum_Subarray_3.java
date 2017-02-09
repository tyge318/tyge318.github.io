public class Solution {
    public int maxSubArray(int[] nums) {
        int[] opt = new int[nums.length]; //max from 0 to i;
        opt[0] = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            opt[i] = Math.max(opt[i-1]+nums[i], nums[i]);
            max = Math.max(max, opt[i]);   
        }
        return max;
    }
}