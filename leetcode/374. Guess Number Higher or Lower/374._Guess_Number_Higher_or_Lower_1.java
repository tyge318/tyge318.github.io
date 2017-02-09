/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left <= right) {
            long sum = (long)right + (long)left;
            int m = (int)(sum >> 1);
            int p = guess(m);
            if(p == 1) {
                left = m+1;
            }
            else if(p == -1) {
                right = m-1;
            }
            else
                return m;
        }
        return right;
    }
}