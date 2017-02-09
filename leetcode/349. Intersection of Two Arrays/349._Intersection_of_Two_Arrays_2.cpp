class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> set1;
        for(int i: nums1)
            set1.insert(i);
        
        vector<int> ans;
        sort(nums2.begin(), nums2.end());
        for(int i=0; i<nums2.size(); i++) {
            if( i>0 && nums2[i] == nums2[i-1])  continue;
            if( set1.find(nums2[i]) != set1.end())
                ans.push_back(nums2[i]);
        }
        return ans;
    }
};