public class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for(int i=0; i<nums.length-1; i++) {
            if( maxPos >= i)
                maxPos = Math.max(maxPos, i+nums[i]);
        }
        return (maxPos >= nums.length-1);
    }
}