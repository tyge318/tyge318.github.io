public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        long result = 0;
        if(n == 0)
            return 1;
        for(int i = 0; i <= n; i++) {
            if(i == 0)
                result += 0;
            else if(i == 1)
                result += 10;
            else{
                if( i-1 <= 9)
                    result += 9 * permutation(9, i-1);
                else
                    break;
            }
        }
        return (int)result;
    }
    public long permutation(int n, int k) {
        long result = 1;
        for(int i=0; i<k; i++)
            result *= (n-i);
        return result;
    }
}