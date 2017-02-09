public class Solution {
    public int searchInsert(int[] nums, int target) {
        return getIndex(nums, 0, nums.length-1, target);
    }
    public int getIndex(int[] nums, int begin, int end, int target) {
        if(begin == end) {
            if( nums[begin] == target)
                return begin;
            else if( nums[begin] > target)
                return begin;
            else
                return begin+1;
        }
        int mid = (begin+end)/2;
        if( nums[mid] == target )
            return mid;
        else if( nums[mid] > target) { //on the left
            return getIndex(nums, begin, Math.max(begin, mid-1), target);
        }
        else { //on the right
            return getIndex(nums, Math.min(mid+1, end), end, target);
        }
    }
}