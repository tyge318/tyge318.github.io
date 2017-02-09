public class Solution {
    public boolean isMatch(String s, String p) {
        /*
        if( s.isEmpty() ) {
            if( p.isEmpty() || p.equals("*") )
                return true;
            else
                return false;
        }
        if( !s.isEmpty() && p.isEmpty() )
            return false;
            */
        String temp = p.replace("*", "");
        if( temp.length() > s.length() )
            return false;
        boolean[][] opt = new boolean[p.length()+1][s.length()+1];
        opt[0][0] = true;
        for(int i=1; i<opt.length; i++) {
            if( i == 1 && p.charAt(i-1) == '*')
                opt[1][0] = true;
            for(int j=0; j<opt[i].length; j++) {
                if( p.charAt(i-1) == '*' ) {
                    if( j > 0)
                        opt[i][j] |= opt[i][j-1];   //'*' covers current character
                    opt[i][j] |= opt[i-1][j];   //'*' covers an empty sequence
                }
                if( j > 0 && (p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1)) ) {
                    opt[i][j] |= opt[i-1][j-1];
                }
            }
        }
        return opt[p.length()][s.length()];
    }
}