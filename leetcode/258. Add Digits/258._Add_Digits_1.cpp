class Solution {
public:
    int addDigits(int num) {    //digital root
        return (num == 0) ? 0: (num-9*floor((num-1)/9));
    }
};