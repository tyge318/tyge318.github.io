public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, l = 0, r = nums.length-1;
        while( l < r) {
            ans += nums[r] - nums[l];
            r--;
            l++;
        }
        return ans;
    }
}