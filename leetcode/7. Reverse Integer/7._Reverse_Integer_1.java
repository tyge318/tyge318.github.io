public class Solution {
    public int reverse(int x) {
        String xStr = String.valueOf(x);
        boolean neg = false;
        if( xStr.charAt(0) == '-') {
            neg = true;
            xStr = xStr.substring(1);
        }
        long value = (new Long((new StringBuilder(xStr)).reverse().toString()));
        value = (neg ? -value: value);
        if( value > Integer.MAX_VALUE || value < Integer.MIN_VALUE)
            return 0;
        else
            return (int)value;
    }
}