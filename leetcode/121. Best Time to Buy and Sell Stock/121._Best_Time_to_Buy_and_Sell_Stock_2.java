public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int[] deltas = new int[prices.length-1];
        for(int i=0; i<deltas.length; i++) {
            deltas[i] = prices[i+1]-prices[i];
        }
        int[] opt = new int[deltas.length];
        int maxP = 0;
        for(int i=0; i<opt.length; i++) {
            opt[i] = Math.max((i==0 ? 0 :opt[i-1])+deltas[i], deltas[i]);
            maxP = Math.max(maxP, opt[i]);
        }
        return maxP;
    }
}