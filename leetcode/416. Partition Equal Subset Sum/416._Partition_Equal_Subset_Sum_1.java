public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums)
            sum += i;
        if( (sum & 1) == 1)
            return false;
        return check(nums, 0, sum>>1);
    }
    public boolean check(int[] nums, int i, int target) {
        if( target < 0 || i >= nums.length )
            return false;
        if( target == 0 || check(nums, i, target-nums[i]) || check(nums, i+1, target) )
            return true;
        return false;
    }
}