public class Solution {
    public int getMoneyAmount(int n) {
        int opt[][] = new int[n+1][n+1];
        for(int left = n-1; left > 0; left--) {
            for(int right = left+1; right <=n; right++) {
                opt[left][right] = Integer.MAX_VALUE;
                for(int i=left; i<right; i++) {
                    opt[left][right] = Math.min(opt[left][right], i+Math.max(opt[left][i-1], opt[i+1][right]) );
                }
            }
        }
        return opt[1][n];
    }
}