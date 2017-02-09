public class Solution {
    public int findDuplicate(int[] nums) {
        int current;
        for(int i=0; i<nums.length; i++) {
            current = nums[i];
            for(int j=i+1; j<nums.length; j++) {
                if( (current ^ nums[j]) == 0)
                    return current;
            }
        }
        return -1;
    }
}