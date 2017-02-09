public class Solution {
    public double myPow(double x, int n) {
        if( x == 0)
            return 0;
        double ans = 1;
        boolean neg = (x < 0);
        boolean negExp = (n < 0);
        x = Math.abs(x);
        int range = (Math.abs(n) < 0)? Integer.MAX_VALUE-1: Math.abs(n);
        if(range > Integer.MAX_VALUE/2) {
            if( x > 1)
                ans = Double.POSITIVE_INFINITY;
            else if (x == 1)
                ans = 1;
            else
                ans = 0;
        }
        else {
            for(int i=0; i<range; i++) {
                ans *= x;
                if( ans == 0 ) {
                   break; 
                }
            }
        }
        if(neg && (range % 2) == 1)
            ans *= (-1);
        if(negExp) {
            ans = (double)1/ans;
        }
        return ans;
    }
}