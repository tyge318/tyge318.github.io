public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        return sbsearch(nums, 0, len-1, target);
    }
    public int rbsearch(int[] nums, int begin, int end, int target) {
        if( end-begin+1 < 3) {
            if( nums[begin] == target)
                return begin;
            else if (nums[end] == target)
                return end;
            else
                return -1;
        } 
        int mid = (begin+end)/2;
        if( nums[mid] == target)
            return mid;
        else if( nums[begin] <= target && target <= nums[mid] ) {
            return rbsearch(nums, begin, mid, target);
        } 
        else {
            return rbsearch(nums, mid+1, end, target);
        }
    }
    public int sbsearch(int[] nums, int begin, int end, int target) {
        if( end-begin+1 < 3) {
            if( nums[begin] == target)
                return begin;
            else if (nums[end] == target)
                return end;
            else
                return -1;
        } 
        int mid = (begin+end)/2;
        if( nums[mid] == target)
            return mid;
        else if( nums[begin] <= nums[mid] && nums[begin] <= target && target <= nums[mid]) {
            return rbsearch(nums, begin, mid, target); //regular b-search [begin:mid]
        }
        else if( nums[begin] >= nums[mid] && (nums[begin] <= target || target <= nums[mid] )) {
            return sbsearch(nums, begin, mid, target); //special b-search [begin:mid]
        }
        else if ( nums[mid+1] <= nums[end] && nums[mid+1] <= target && target <= nums[end]) {
            return rbsearch(nums, mid+1, end, target); //regular b-search [mid+1:end]
        }
        else if( nums[mid+1] >= nums[end] && (nums[mid+1] <= target || target <= nums[end] )){
            return sbsearch(nums, mid+1, end, target); //special b-search [mid+1:end]
        }
        else
            return -1;
    }
}