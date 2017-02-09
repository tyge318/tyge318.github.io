public class Solution {
    public int maxProfit(int[] prices) {
        if( prices.length < 2) return 0;
        int n = prices.length;
        
        int begin = n-2, end = 0;
        for(int i=0; i<n-1; i++) {
            prices[i] = prices[i+1] - prices[i];
            if( prices[i] > 0) {
                begin = Math.min(begin, i);
                end = Math.max(end, i);
            }
        }
        if( end-begin+1 < 0) return 0;
        int ans = 0;
        int[] opt1 = new int[end-begin+1];  
        int[] opt2 = new int[end-begin+1];  
        for(int i=begin; i<=end; i++) {
            int best1 = 0, best2 = 0;
            for(int j=begin; j<=i; j++) {
                opt1[j-begin] = Math.max((j-begin-1<0 ? 0 : opt1[j-begin-1])+prices[j], prices[j]);
                best1 = Math.max(best1, opt1[j-begin]);   
            }
            for(int j=end; j>=i+1; j--) {
                opt2[j-begin] = Math.max((j==end ? 0 : opt2[j-begin+1])+prices[j], prices[j]);
                best2 = Math.max(best2, opt2[j-begin]);
            }
            ans = Math.max(ans, best1+best2);
        }
        return ans;
    }
}