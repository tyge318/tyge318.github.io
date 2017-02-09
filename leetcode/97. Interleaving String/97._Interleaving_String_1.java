public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if( m+n != s3.length())
            return false;
        
        boolean[][] opt = new boolean[m+1][n+1];
        //define opt[i][j] as whether s1[0:i] and s2[0:j] forms s3[0:i+j]
        opt[0][0] = true;
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if( i == 0 && j == 0)
                    continue;
                if( i == 0) {
                    opt[i][j] = (s2.substring(0, j).equals(s3.substring(0, j)) );
                    continue;
                }
                if( j == 0) {
                    opt[i][j] = (s1.substring(0, i).equals(s3.substring(0, i)) );
                    continue;
                }
                if( !opt[i-1][j] && !opt[i][j-1] ) {
                    opt[i][j] = false;
                    continue;
                }
                String last = s3.substring(0, i+j-1);
                String target = s3.substring(0, i+j);
                if( opt[i-1][j] ) { //last is from top
                    opt[i][j] |= ((s1.substring(i-1, i) + last).equals(target ) ||
                                  (last + s1.substring(i-1, i)).equals(target ));
                }
                if( opt[i][j-1] ) { //last is from left
                    opt[i][j] |= ((s2.substring(j-1, j) + last).equals(target ) ||
                                  (last + s2.substring(j-1, j)).equals(target ));
                }
                            
            }
        }
        return opt[m][n];
    }
}