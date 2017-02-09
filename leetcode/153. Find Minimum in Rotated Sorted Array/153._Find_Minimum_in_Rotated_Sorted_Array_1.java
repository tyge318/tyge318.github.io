public class Solution {
    public int findMin(int[] nums) {
        //return rangeMin(nums, 0, nums.length-1);
        return irangeMin(nums);
    }
    //iterative
    public int irangeMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while( left < right) {
            int mid = (left+right)/2;
            if( mid-1 >= left && nums[mid] < nums[mid-1] )
                return nums[mid];
            if( nums[mid] > nums[right] )
                left = mid+1;
            else
                right = mid;
        }
        return nums[left];
    }
    //recursive
    public int rangeMin(int[] nums, int begin, int end) {
        if( begin == end )
            return nums[begin];
        if( end == begin+1 )
            return Math.min(nums[begin], nums[end]);
        int mid = (begin+end)/2;
        if( nums[mid] < nums[mid-1] )
            return nums[mid];
        if( nums[mid] > nums[end] )
            return rangeMin(nums, Math.min(mid+1, end), end);
        else
            return rangeMin(nums, begin, mid);
    }
}