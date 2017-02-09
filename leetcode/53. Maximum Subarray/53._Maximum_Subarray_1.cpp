class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> opt;
        int ans = INT_MIN;
        for(int i=0; i<nums.size(); i++) {
            opt.push_back( max(((i-1 < 0) ? 0 : opt[i-1]) + nums[i], nums[i]) );
            ans = max(ans, opt[i]);
        }
        return ans;
    }
};