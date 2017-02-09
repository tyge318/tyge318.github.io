public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        ans[0] = 1;
        int s = primes.length;
        int[] candidates = new int[s];
        int[] idx = new int[s];
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<s; j++) {
                candidates[j] = ans[idx[j]] * primes[j];
            }
            ans[i] = getMin(candidates);
            for(int j=0; j<s; j++) {
                if(ans[i] == candidates[j])
                    idx[j]++;
            }
        }
        return ans[n-1];
    }
    public int getMin(int[] candidates) {
        int output = candidates[0];
        for(int i=1; i<candidates.length; i++)
            output = Math.min(output, candidates[i]);
        return output;
    }
}