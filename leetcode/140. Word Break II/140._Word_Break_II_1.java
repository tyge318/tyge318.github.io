public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> opt[] = new ArrayList[s.length()+1];
        opt[0] = new ArrayList<String>();
        
        for(int i=0; i<=s.length(); i++) {
            if( opt[i] == null )
                continue;
            for(String word: wordDict) {
                int len = word.length();
                if( i+len > s.length() )
                    continue;
                if( word.equals(s.substring(i, i+len)) ) {
                    if( opt[i+len] == null)
                        opt[i+len] = new ArrayList<String>();
                    opt[i+len].add(word);
                }
            }
        }
        List<String> ans = new LinkedList<String>();
        if( opt[s.length()] == null)
            return ans;
        buildList(opt, s.length(), ans, new ArrayList<String>() );
        return ans;
        
    }
    public void buildList(List<String> opt[], int end, List<String> ans, List<String> last) {
        if( end <= 0 ) {
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<last.size(); i++) {
                temp.insert(0, (" "+last.get(i) ) );
            }
            ans.add( temp.toString().trim() );
            return;
        }
        for(String word: opt[end]) {
            last.add(word);
            buildList(opt, end-word.length(), ans, last);
            last.remove(last.size()-1);
        }
    }
 }