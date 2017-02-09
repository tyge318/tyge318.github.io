public class Solution {
    public int numTrees(int n) {
        int[] opt = new int[n+1];
        opt[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++)
                opt[i] += opt[j]*opt[i-j-1];
        }
        return opt[n];
    }
}