public class Solution {
    public int findComplement(int num) {
        int mask = 0, temp = num;
        while( temp > 0 ) {
            mask <<= 1;
            mask |= 1;
            temp >>>= 1;
        }
        return (num ^ mask);
    }
}