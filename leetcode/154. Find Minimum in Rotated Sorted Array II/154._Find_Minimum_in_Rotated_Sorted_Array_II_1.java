public class Solution {
    public int findMin(int[] nums) {
        return irangeMin(nums);
    }
    public int irangeMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while( left+1 < right) {
            int mid = (left+right)/2;
            if( nums[right] == nums[mid] ) {
                right--;
                continue;
            }
            if( nums[mid] < nums[left] || nums[right] > nums[mid])
                right = mid;
            else
                left = mid+1;
        }
        return Math.min(nums[left], nums[right]);
    }
}