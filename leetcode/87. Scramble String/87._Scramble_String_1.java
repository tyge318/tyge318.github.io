public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        //opt[k][i][j] stores whether s1[i:i+k] is scramble of s2[j:j+k]
        boolean[][][] opt = new boolean[n+1][n][n];
        for(int i=0; i<n; i++) 
            for(int j=0; j<n; j++)
                opt[1][i][j] = (s1.charAt(i) == s2.charAt(j) );
        
        for(int k=1; k<=n; k++) {
            for(int i=0; i+k<=n; i++) {
                for(int j=0; j+k<=n; j++) {
                    for(int m=1; m<k; m++) {
                        opt[k][i][j] |= ( (opt[m][i][j] && opt[k-m][i+m][j+m] ) || 
                                          (opt[m][i+(k-m)][j] && opt[k-m][i][j+m]) );
                    }
                }
            }
        }
        return opt[n][0][0];
    }
}