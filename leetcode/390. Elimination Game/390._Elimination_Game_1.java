public class Solution {
    public int lastRemaining(int n) {
        int begin = 1, d = 1;
        int counter = 0;
        while( n > 1) {
            n /= 2;
            d *= 2;
            counter++;
            if( counter % 2 == 1) { //left to right
                begin += (d/2);
                begin += (n-1)*d;
            }
            else { //right to left
                begin -= (d/2);
                begin -= (n-1)*d;
            }
        }
        return begin;
    }
}