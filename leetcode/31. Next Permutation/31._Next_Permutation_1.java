public class Solution {
    public void nextPermutation(int[] nums) {
        int targetPos = findTarget(nums);
        if( targetPos == -1 ) {
            Arrays.sort(nums);
        }
        else {
            int toChangePos = findChange(nums, targetPos);
            swap(nums, targetPos, toChangePos);
            reverseToTheRight(nums, targetPos);
        }
    }
    public int findTarget(int[] nums) {
        int pos = nums.length-1;
        while( pos > 0 ) {
            if( nums[pos-1] < nums[pos] )
                return (pos-1);
            pos--;
        }
        return -1;
    }
    public int findChange(int[] nums, int targetPos) {
        int target = nums[targetPos];
        int pos = nums.length-1;
        while( pos >= 0 ) {
            if( nums[pos] > target)
                return pos;
            pos--;
        }
        return -1;
    }
    public void swap(int[] nums, int targetPos, int toChangePos) {
        int temp = nums[targetPos];
        nums[targetPos] = nums[toChangePos];
        nums[toChangePos] = temp;
    }
    public void reverseToTheRight(int[] nums, int targetPos) {
        int left = targetPos+1, right = nums.length-1;
        while( right > left) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}