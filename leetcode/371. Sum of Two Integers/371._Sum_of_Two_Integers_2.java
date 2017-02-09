public class Solution {
    public int getSum(int a, int b) {
        int ans = 0, carry = 0, t = 1;
        while( (a | b | carry) != 0) {
            if( ((a ^ b ^ carry) & 1) != 0 )
                ans |= t;
            t = t << 1;
            carry = ( a&b | b&carry | a&carry ) & 1;
            a = a >>> 1;
            b = b >>> 1;
        }
        return ans;
    }
}