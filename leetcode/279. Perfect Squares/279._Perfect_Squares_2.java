public class Solution {
    public int numSquares(int n) {
        int[] opt = new int[n+1];
        Arrays.fill(opt, n);
        for(int i=1; i*i<=n; i++) {
            opt[i*i] = 1;
            if( i*i == n)   return 1;
        }
        
        for(int i=2; i<=n; i++) {
            if( opt[i] == 1) continue;
            for(int j=1; j*j<i; j++) {
                opt[i] = Math.min(opt[i], opt[i-j*j]+1);
            }
        }
        return opt[n];
    }
}