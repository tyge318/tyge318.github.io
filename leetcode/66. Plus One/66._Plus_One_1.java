public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if( digits[n-1] == 9) {
            int i = n-1;
            while( i >= 0 && digits[i] == 9)    {
                digits[i] = 0;
                i--;
            }
            if( i == -1) {
                int[] ans = new int[n+1];
                ans[0] = 1;
                return ans;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        else {
            digits[n-1]++;
            return digits;
        }
    }
}