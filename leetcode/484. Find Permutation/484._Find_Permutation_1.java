public class Solution {
    public int[] findPermutation(String s) {
        int n = s.length()+1;
        int L = 0;
        
        int[] ans = new int[n];
        int index = 0;
        for(int i=0; i<s.length(); i++) {
            if( s.charAt(i) == 'I' ) {
                for(int j=i+1; j>L; j--)
                    ans[index++] = j;
                L = i+1;
            }
        }
        if( L != n ) {
            for(int j=n; j>L; j--)
                ans[index++] = j;
            L = n;
        }
        return ans;
    }
}