public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] opt = new int[m+1][n+1];
        //define: opt[i][j] as number of solutions for s[0:i] and t[0:j]
        opt[0][0] = 1;
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=Math.min(i, n); j++) {
                if( i==0 && j==0)
                    continue;
                opt[i][j] += opt[i-1][j];
                if( i>0 && j>0) {
                    if( s.charAt(i-1) == t.charAt(j-1) )
                        opt[i][j] += opt[i-1][j-1];
                }
            }
        }
        return opt[m][n];
    }
}