class Solution {
public:
    bool isPowerOfTwo(int n) {
        return fmod(log2(n), 1)==0;
    }
};