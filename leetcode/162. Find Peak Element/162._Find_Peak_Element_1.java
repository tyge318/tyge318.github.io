public class Solution {
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        if(size == 1)
            return 0;
        for(int i=0; i<size; i++) {
            if(i == 0 && nums[i+1] < nums[i]) {
                return i;
            }
            else if(i == size-1 && nums[i-1] < nums[i]) {
                return i;
            }
            else {
                if( i == 0 || i == size-1)
                    continue;
                if( nums[i-1] < nums[i] && nums[i+1] < nums[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}