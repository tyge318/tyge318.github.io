public class Solution {
    public int missingNumber(int[] nums) {
        boolean[] check = new boolean[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            check[nums[i]] = true;
        }
        int ans = -1;
        for(int i=0; i<check.length; i++) {
            if(check[i] == false) {
                ans = i;
            }
        }
        return ans;
            
    }
}