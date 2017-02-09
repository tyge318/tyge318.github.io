public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        ans[nums.length-1] = 1;
        //right to left
        for(int i=nums.length-1; i>0; i--)
            ans[i-1] = ans[i]*nums[i];
        
        //left to right
        int left = 1;
        for(int i=0; i<nums.length; i++) {
            ans[i] *= left;
            left *= nums[i];
        }
        return ans;
    }
}