class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> ans;
        for(int i=0; i<numbers.size(); i++) {
            int i2;
            if( (i2= binarySearch(numbers, i+1, target-numbers[i])) != -1) {
                ans.push_back(i+1);
                ans.push_back(i2+1);
                return ans;
            }
        }
        return ans;
    }
    int binarySearch(vector<int>& numbers, int begin, int target) {
        int end = numbers.size()-1;
        while( begin <= end) {
            int mid = (begin+end)/2;
            if( numbers[mid] == target) return mid;
            else if( numbers[mid] > target) end = mid-1;
            else    begin = mid+1;
        }
        return -1;
    }
};