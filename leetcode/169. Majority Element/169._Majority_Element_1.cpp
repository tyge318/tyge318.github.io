class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0, ans = INT_MIN;
        for(int i: nums) {
            if( count == 0) ans = i;
            if( i == ans )  count++;
            else    count--;
        }
        return ans;
    }
};