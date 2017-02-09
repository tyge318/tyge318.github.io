public class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        
        long x = 1;
        for(int p = 2; p < 100; p++) {
            if( (x << p) < num) {
                long k = computeK(num, p);
                if( k != -1)
                    return String.valueOf(k);
            }
        }
        return String.valueOf(num-1);
    }
    private long computeK(long num, int p) {
        long l = 1, r = (long)(Math.pow(num, 1.0/p)+1);
        while( l < r) { //binary search
            long mid = (l+r)/2;
            long value = baseXValue(mid, p);
            if( value == num )  return mid;
            else if( value > num)   r = mid;
            else    l = mid+1;
        }
        return -1;
    }
    private long baseXValue(long x, int p) {
        long ans = 0, cur = 1;
        for(int i=0; i<=p; i++) {
            ans += cur;
            cur *= x;
        }
        return ans;
    }
}