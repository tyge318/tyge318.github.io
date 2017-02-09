class Solution {
public:
    bool isStrobogrammatic(string num) {
        int left = 0, right = num.size()-1;
        while( left <= right ) {
            if( num[left] == num[right]) {
                if( num[left] == '0' || num[left] == '1' || num[left] == '8') {
                    left++; right--;
                    continue;
                }
                else
                    return false;
            }
            else {
                if( num[left] == '9' && num[right] == '6' || num[left] == '6' && num[right] == '9') {
                    left++; right--;
                    continue;
                }
                else
                    return false;
            }
        }
        return true;
    }
};