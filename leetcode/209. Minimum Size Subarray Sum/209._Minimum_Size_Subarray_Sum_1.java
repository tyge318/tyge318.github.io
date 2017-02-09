public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[][] opt = new int[nums.length][2]; 
        //define: opt[i][j] where opt[i][0] = begin index, opt[i][1] = sum to i.
        int ans = nums.length;
        if( ans == 0)   return 0;
        opt[0][0] = 0;
        opt[0][1] = nums[0];
        if( opt[0][1] >= s) {
            ans = 1;
        }
        for(int i=1; i<nums.length; i++) {
            int tempSum = opt[i-1][1] + nums[i];
            if( tempSum < s) {
                opt[i][0] = opt[i-1][0];
                opt[i][1] = tempSum;
            }
            else {
                int j = opt[i-1][0];
                while(j<i) {
                    if( tempSum - nums[j] >= s )
                        tempSum -= nums[j];
                    else
                        break;
                    j++;
                }
                opt[i][0] = j;
                opt[i][1] = tempSum;
                ans = Math.min(ans, i-opt[i][0]+1);
            }
        }
        //System.out.println("opt = " + Arrays.deepToString(opt));
        return (opt[nums.length-1][0] == 0 && opt[nums.length-1][1] < s) ? 0 : ans;
    }
}