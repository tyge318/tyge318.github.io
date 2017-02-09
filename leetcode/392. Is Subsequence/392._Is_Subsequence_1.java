public class Solution {
    public boolean isSubsequence(String s, String t) {
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            int begin = 0;
            if( (begin = t.indexOf(cc)) != -1) {
                t = t.substring(begin+1);
            }
            else
                return false;
        }
        return true;
    }
    public boolean dpSolution(String s, String t) {
        int m = s.length(), n = t.length();
        boolean[][] opt = new boolean[m+1][n+1];
        //define opt[i][j] as solution for s[0:i] and t[0:j]
        opt[0][0] = true;
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i==0 && j==0 || i>j)    continue;
                if( i == 0 ) {   //empty string is a subsequence of any string
                    opt[0][j] = true;
                    continue;
                }
                opt[i][j] = (s.charAt(i-1) == t.charAt(j-1)) ? opt[i-1][j-1]: opt[i][j-1];
            }
        }
        return opt[m][n];
    }
}