public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length-1;
        int size = nums.length;
        while( left < size ) {
            if( nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                right--;
                size--;
            }
            else {
                left++;
            }
        }
        return size;
    }
}