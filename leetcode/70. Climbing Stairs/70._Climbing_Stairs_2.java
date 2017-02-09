public class Solution {
    public int climbStairs(int n) {
        if( n == 0 || n == 1)
            return 1;
        if( n == 2)
            return 2;
        int[] opt = new int[n+1];
        opt[0] = 1;
        opt[1] = 1;
        opt[2] = 2;
        for(int i=3; i<=n; i++) {
            opt[i] = opt[i-1] + opt[i-2];
        }
        return opt[n];
    }
}