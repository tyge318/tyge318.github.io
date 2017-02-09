public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return (minMax(nums, 0, nums.length-1) >= 0);
    }
    public int minMax(int[] nums, int left, int right) {
        return (left == right) ? nums[left] : Math.max( nums[left] - minMax(nums, left+1, right), nums[right] - minMax(nums, left, right-1) );
    }
}