class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> trace(nums.begin(), nums.end());
        return (trace.size() < nums.size());
    }
};