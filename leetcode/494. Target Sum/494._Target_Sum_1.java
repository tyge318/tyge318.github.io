public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            nums[i] += nums[i];
        }
        return sum < S ? 0 : subsetSum(nums, sum+S);
    }
    public int subsetSum(int[] nums, int sum) {
        int n = nums.length;
        int[][] opt = new int[sum+1][n+1];
        //opt[i][j] = the solution to get sum i with the first j numbers
        opt[0][0] = 1;
        for(int i=0; i<=sum; i++) {
            for(int j=1; j<=n; j++) {
                opt[i][j] = opt[i][j-1];    //nums[j-1] is not included in the subset    
                if( i - nums[j-1] >= 0)     //nums[j-1] is included in the subset
                    opt[i][j] += opt[i - nums[j-1]][j-1];   //that means the subset sum of first j-1 numbers needs to be j-nums[j-1]
            }
        }
        return opt[sum][n];
    }
}