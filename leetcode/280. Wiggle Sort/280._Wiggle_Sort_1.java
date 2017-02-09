public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int temp = nums[i-1];
            if( (i%2 == 1) == (temp > nums[i]) ) {
                nums[i-1] = nums[i];
                nums[i] = temp;
            }
        }
    }
}