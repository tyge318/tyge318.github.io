class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> set1(nums1.begin(), nums1.end());
        
        vector<int> ans;
        for(int i: nums2) {
            if( set1.count(i)) {    //i in set1
                ans.push_back(i);
                set1.erase(i);
            }
        }
        return ans;
    }
};