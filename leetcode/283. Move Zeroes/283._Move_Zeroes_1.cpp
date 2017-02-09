class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int tail = nums.size()-1;
        for(int i=0; i<tail; ) {
            if( nums[i] == 0) {
                nums.erase(nums.begin()+i);
                nums.insert(nums.begin()+tail, 0);
                tail--;
                continue;
            }
            i++;
        }
    }
};