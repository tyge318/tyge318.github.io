public class Solution {
    public int rob(int[] nums) {
        if( nums.length == 0)
            return 0;
        int[] opt = new int[nums.length];
        //case1: rob first one, so can't rob the very last one in anyway.
        opt[0] = nums[0];
        int ans1 = opt[0];
        for(int i=1; i<nums.length-1; i++) {
            opt[i] = Math.max(opt[i-1], nums[i] + ((i-2 >=0) ? opt[i-2]: 0) );
            ans1 = Math.max(ans1, opt[i]);
        }
        //case2: don't rob the first one, so it's possible to rob the very last one.
        opt[0] = 0;
        int ans2 = 0;
        for(int i=1; i<nums.length; i++) {
            opt[i] = Math.max(opt[i-1], nums[i] + ((i-2 >=0) ? opt[i-2]: 0) );
            ans2 = Math.max(ans2, opt[i]);
        }
        return Math.max(ans1, ans2);
    }
}