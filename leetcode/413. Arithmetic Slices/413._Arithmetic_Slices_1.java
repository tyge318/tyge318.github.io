public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if( n <= 2)
            return 0;
        int last_d = A[1] - A[0], count = 0, ans = 0;
        for(int i=2; i<n; i++) {
            if( A[i] - A[i-1] == last_d ) {
                count++;
            }
            else {
                for(int j=count; j>0; j--)
                    ans += j;
                last_d = A[i] - A[i-1];
                count = 0;
            }
        }
        for(int j=count; j>0; j--)
            ans += j;
        return ans;
        
    }
}