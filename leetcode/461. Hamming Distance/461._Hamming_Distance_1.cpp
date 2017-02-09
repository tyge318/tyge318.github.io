class Solution {
public:
    int hammingDistance(int x, int y) {
        int ans = 0, n = x ^ y;
        while( n > 0 ) {
            if( (n & 0x1) ) ans++;
            n >>= 1;
        }
        return ans;
    }
};