public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int temp = log2(n-m);
        int tailMask = (0xffffffff << temp);
        return (m & n & tailMask);
    }
    public int log2(int k) {
        int ans = 0;
        while( k > 0) {
            k = k >> 1;
            ans++;
        }
        return ans;
    }
}