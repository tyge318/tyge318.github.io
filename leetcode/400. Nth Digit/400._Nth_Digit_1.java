public class Solution {
    public int findNthDigit(int n) {
        int digitCount = 1;
        long offset = 9;
        while( n > digitCount*offset ) {
            n -= (int)offset*digitCount;
            digitCount++;
            offset *= 10;
        }
        
        int target = (int)Math.pow(10, digitCount-1) + (n-1)/digitCount;
        int targetNth = (n-1) % digitCount;
        return String.valueOf(target).charAt(targetNth) - '0';
    }
}