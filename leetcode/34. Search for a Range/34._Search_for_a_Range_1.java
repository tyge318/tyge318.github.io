public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    public int[] search(int[] nums, int begin, int end, int target) {
        int[] ans = new int[2];
        if( begin == end ) {
            if( nums[begin] == target) {
                ans[0] = begin;
                ans[1] = begin;
                return ans;
            }
            else {
                ans[0] = -1;
                ans[1] = -1;
                return ans;
            }
        }
        int mid = (begin+end)/2;
        if( nums[mid] == target) {
            int leftIndex = search(nums, begin, Math.max(begin, mid-1), target)[0];
            int rightIndex = search(nums, Math.min(end, mid+1), end, target)[1];
            ans[0] = ((leftIndex == -1) ? mid : leftIndex);
            ans[1] = ((rightIndex == -1) ? mid: rightIndex);
            return ans;
        }
        else if( nums[mid] > target ) { //on the left
            return search(nums, begin, Math.max(begin, mid-1), target);
        }
        else {  //on the right
            return search(nums, Math.min(end, mid+1), end, target);
        }
    }
}