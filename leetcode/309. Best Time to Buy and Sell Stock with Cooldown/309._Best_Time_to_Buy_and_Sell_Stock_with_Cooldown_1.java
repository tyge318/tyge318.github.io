public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int[] opt_buy = new int[prices.length]; 
        int[] opt_sell = new int[prices.length];
        opt_buy[0] = -prices[0];
        opt_sell[0] = 0;
        opt_buy[1] = Math.max(-prices[0], -prices[1]);      //either buying today or buying yesterday (cool down today).
        opt_sell[1] = Math.max(0, prices[1]-prices[0]);     //either nothing to sell(0) or sell what bought yesterday.
        for(int i=2; i<prices.length; i++) {
            opt_buy[i] = Math.max(opt_buy[i-1], opt_sell[i-2]-prices[i]); //buying yesterday or buying today.
            opt_sell[i] = Math.max(opt_sell[i-1], opt_buy[i-1]+prices[i]); //selling yesterday or selling today.
        }
        return opt_sell[prices.length-1];
    }
}