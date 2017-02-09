public class Solution {
    public int numWays(int n, int k) {
        if(n == 0)
            return 0;
        if(n == 1)
            return k;
        int same = k, diff = k*(k-1);
        for(int i=3; i<=n; i++) {
            int tempSame = same;
            //same to previous means previous and the one before previous can't be same.
            same = diff;
            //different with previous means previous is allowed for two cases
            diff = (diff+tempSame)*(k-1);
        }
        return same+diff;
    }
}