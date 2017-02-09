public class Solution {
    public int maxSubArray(int[] nums) {
        return findMSA(nums, 0, nums.length-1);
    }
    public int findMSA(int[] nums, int begin, int end) {
        if( begin == end )
            return nums[begin];
        int mid = (begin + end) / 2;
        int max1 = findMSA(nums, begin, Math.max(begin, mid-1));
        int max2 = findMSA(nums, Math.min(mid+1, end), end);
        
        int leftMax = 0, rightMax = 0;
        int left = (mid-1 < begin) ? -nums[begin]: 0;
        for(int i=Math.max(mid-1, begin); i>=begin; i--) {
            left += nums[i];
            leftMax = Math.max(leftMax, left);
        }
        int right = 0;
        for(int i=Math.min(mid+1, end); i<=end; i++) {
            right += nums[i];
            rightMax = Math.max(rightMax, right);
        }
        return Math.max(nums[mid]+leftMax+rightMax, Math.max(max1, max2) );
    }
}