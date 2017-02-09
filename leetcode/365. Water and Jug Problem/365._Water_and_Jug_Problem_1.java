public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if( x < y ) {
            int temp = x;
            x = y;
            y = temp;
        }
        int gcd = getGCD(x, y);
        if( gcd == 0)
            return (z == 0);
        return ((z % gcd == 0) && ( z <= x+y) );
    }
    public int getGCD(int a, int b) {
        if( b == 0 )
            return a;
        return getGCD( b, (a % b));
    }
}