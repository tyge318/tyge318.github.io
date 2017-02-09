public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ptr1 = -2, ptr2 = -1, ans = 0;
        for(int i=0; i<nums.length; i++) {
            if( nums[i] == 1)   continue;
            if( ptr2 != -1 )    ans = Math.max(ans, i-1-ptr1);
            ptr1 = ptr2;
            ptr2 = i;
        }
        ans = (ptr2 != -1) ? Math.max(ans, nums.length-1-ptr1) : nums.length;
        return ans;
    }
}