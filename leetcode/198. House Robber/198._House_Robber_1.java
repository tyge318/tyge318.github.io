public class Solution {
    public int rob(int[] nums) {
        if( nums.length == 0 )
            return 0;
        int[] opt = new int[nums.length];   
        //opt[i] = max profit can be made for robbing from day 0 to day i
        opt[0] = nums[0];
        int ans = nums[0];
        for(int i=1; i<nums.length; i++) {
            opt[i] = Math.max(opt[i-1], nums[i] + ((i-2 >=0) ? opt[i-2]: 0) );
            ans = Math.max(ans, opt[i]);
        }
        return ans;
    }
}