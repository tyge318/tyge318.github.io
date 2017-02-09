public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] opt = new boolean[s.length()+1];
        opt[0] = true;
        for(int i=0; i<opt.length; i++) {
            if( !opt[i] )
                continue;
            for(String word: wordDict) {
                if( i+word.length() > s.length() || opt[i+word.length()] )
                    continue;
                if( word.equals(s.substring(i, i+word.length())) )
                    opt[i+word.length()] = true;
            }
        }
        return opt[s.length()];
        //return validConcat(s, wordDict, 0);
    }
    /*
    public boolean validConcat(String s, Set<String> wordDict, int i) {
        if( i == s.length() )
            return true;
        for(int j=i; j<s.length(); j++) {
            String prefix = s.substring(i, j+1);
            if( wordDict.contains(prefix) && validConcat(s, wordDict, j+1) )
                return true;
        }
        return false;
    } */
}