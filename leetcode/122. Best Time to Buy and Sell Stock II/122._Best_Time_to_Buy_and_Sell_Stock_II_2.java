public class Solution {
    public int maxProfit(int[] prices) {
        if( prices.length == 0) return 0;
        int min = Integer.MAX_VALUE, max = 0, ans = 0;
        for(int i=0; i<prices.length; i++) {
            if( prices[i] < (i-1<0 ? Integer.MAX_VALUE: prices[i-1]) ) {
                min = prices[i];
                ans += max;
                max = 0;
            }
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        ans += max;
        return ans;
    }
}