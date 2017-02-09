public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return Integer.compare(a.length(), b.length());
            }  
        });
        for(String s: words) {
            if( wordBreak(s, dict) )
                ans.add(s);
            dict.add(s);
        }
        return ans;
    }
    public boolean wordBreak(String s, Set<String> wordDict) {
        if( wordDict.isEmpty()) return false;
        boolean[] opt = new boolean[s.length()+1];
        opt[0] = true;
        for(int j=1; j<=s.length(); j++) {
            for(int i=0; i < j; i++) {
                if( !opt[i] )   continue;
                if( wordDict.contains(s.substring(i, j)) ) {
                    opt[j] = true;
                    break;
                }
            }
        }
        return opt[s.length()];
    }
}