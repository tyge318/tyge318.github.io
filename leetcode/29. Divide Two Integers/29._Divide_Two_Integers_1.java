public class Solution {
    public int divide(int dividend, int divisor) {
        if( divisor == 0 )
            return ((dividend >= 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        if( dividend == 0)
            return 0;
        if( dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
            
        boolean negative = ( dividend < 0 && divisor > 0 ) || (dividend > 0 && divisor < 0);
        long A = Math.abs((long)dividend);
        long B = Math.abs((long)divisor);
        int q = 0, shift = 0;

        while( A >= B) {
            while( A - (B << shift) >= 0 )
                shift++;
            q += (1 << (shift-1));
            A -= (B << (shift-1));
            shift = 0;
        }
        return (negative ? -q : q);
    }
}