public class Solution {
    public int mySqrt(int x) {
        if( x == 0)
            return 0;
        int left = 1, right = (x/2)+1;
        int mid = 0;
        while( left <= right ) {
            if( mid == (left + right)/2 )
                break;
            mid = (left + right)/2;
            if( mid < x/mid ) {
                left = mid;
            }
            else if( mid > x/mid ) {
                right = mid;
            }
            else {
                break;
            }
        }
        return mid;
    }
    
}