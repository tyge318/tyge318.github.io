public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] opt = new boolean[s.length()+1];
        opt[0] = true;
        for(int i=0; i<opt.length; i++) {
            if(!opt[i]) continue;
            for(String word: wordDict) {
                if( i+word.length() > s.length() || opt[i+word.length()] )  continue;
                if( word.equals(s.substring(i, i+word.length()) ) )
                    opt[i+word.length()] = true;
            }
        }
        return opt[s.length()];
    }
}