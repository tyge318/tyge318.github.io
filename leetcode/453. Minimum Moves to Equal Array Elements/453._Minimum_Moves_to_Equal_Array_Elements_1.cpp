class Solution {
public:
    int minMoves(vector<int>& nums) {
        //a move = increasing n-1 element by 1 = decreasing an element by 1
        int ans = 0;
        if( nums.size() == 0)   return ans;
        int minimum = nums[0];
        for(int i=1; i<nums.size(); i++) 
            minimum = min(minimum, nums[i]);
        for(int i: nums)
            ans += (i-minimum);
        return ans;
    }
};