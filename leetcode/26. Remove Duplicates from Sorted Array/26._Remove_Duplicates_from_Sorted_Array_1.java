public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int sameCount = 0;
        for(int i=1; i<length; i++) {
            if( nums[i] == nums[i-1]) {
                sameCount++;
            }
            else {
                shiftLeft(nums, i, sameCount);
                length-= sameCount;
                i = i-sameCount;
                sameCount = 0;
            }
        }
        if( sameCount != 0)
            length-=sameCount;
        return length;
    }
    public void shiftLeft(int[] nums, int index, int units) {
        if( (index-units) >= 0 ) {
            for(int i=index; i<nums.length; i++)
                nums[i-units] = nums[i];
        }
    }
}