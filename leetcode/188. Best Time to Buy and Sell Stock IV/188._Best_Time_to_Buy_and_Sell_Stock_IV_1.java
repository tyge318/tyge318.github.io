public class Solution {
    public int maxProfit(int k, int[] prices) {
        if( prices.length < 2 || k <= 0 )
            return 0;
        
        if( k >= prices.length/2) {
            int max = 0;
            for(int i=1; i<prices.length; i++) {
                max += Math.max(0, prices[i]-prices[i-1]);
            }
            return max;
        }
        else {
            int max_global[] = new int[k+1];
            int max_local[] = new int[k+1];
            
            for(int i=1; i<prices.length; i++) {
                int diff = prices[i] - prices[i-1];
                for(int j=k; j>0; j--) {
                    max_local[j] = Math.max(max_global[j-1]+Math.max(diff, 0), max_local[j]+diff);
                    max_global[j] = Math.max(max_local[j], max_global[j]);
                }
            }
            return max_global[k];
        }
    }
}