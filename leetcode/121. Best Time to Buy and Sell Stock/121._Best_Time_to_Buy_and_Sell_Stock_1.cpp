class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if( prices.size() < 2)  return 0;
        vector<int> diff(prices.size()-1);
        for(int i=1; i<prices.size(); i++)
            diff[i-1] = prices[i]-prices[i-1];
        vector<int> opt(diff.size());
        int ans = 0;
        for(int i=0; i<opt.size(); i++) {
            opt[i] = max((i-1 < 0 ? 0: opt[i-1])+diff[i], diff[i]);
            ans = max(ans, opt[i]);
        }
        return ans;
    }
};