public class Solution {
    public int minPatches(int[] nums, int n) {
        long last = 1;
        int i = 0, count = 0;
        while( last <= n) {
            if( i < nums.length && nums[i] <= last ) {
                last += nums[i];
                i++;
            }
            else{
                last <<= 1;
                count++;
            }
        }
        return count;
    }
}