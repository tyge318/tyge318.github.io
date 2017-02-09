public class Solution {
    public String encode(String s) {
        String[][] opt = new String[s.length()][s.length()];
        //opt[i][j] is the optimal solution for substring(i, j+1);
        for(int k=0; k<s.length(); k++) {
            for(int i=0; i<s.length()-k; i++) {
                int j = i+k;
                String substr = s.substring(i, j+1);
                opt[i][j] = substr;
                if( substr.length() < 5)    continue;
                shortenByConcatenation(opt, i, j);
                shortenByPatternize(opt, substr, i, j);
            }
        }
        return opt[0][s.length()-1];
    }
    public void shortenByConcatenation(String[][] opt, int i, int j) {
        for(int k=i; k<j; k++) {
            if( opt[i][k] == null || opt[k+1][j] == null)   continue;
            if( opt[i][j].length() > (opt[i][k]+opt[k+1][j]).length() ) {
                opt[i][j] = opt[i][k] + opt[k+1][j];
            }
        }
    }
    public void shortenByPatternize(String[][] opt, String original, int i, int j) {
        for(int k=0; k<original.length(); k++) {
            String p = original.substring(0, k+1);
            if( p == null)  continue;
            if( original.length() % p.length() != 0)    continue;
            if( !original.replaceAll(p, "").isEmpty() ) continue;
            String temp = (original.length()/p.length())+"["+ opt[i][i+k] +"]";
            if( opt[i][j].length() > temp.length() )
                opt[i][j] = temp;
        }
    }
}