public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        int ssLen = words[0].length()*words.length;
        HashMap<String, Integer> wordDict = new HashMap<String, Integer>();
        for(int i=0; i<words.length; i++) {
            if( wordDict.containsKey(words[i]) )
                wordDict.put(words[i], wordDict.get(words[i])+1);
            else
                wordDict.put(words[i], 1);
        }
        int tokenLen = words[0].length();
        for(int j=0; j<tokenLen; j++) { //j=start position of a word
            HashMap<String, Integer> dict = new HashMap<String, Integer>();
            ArrayList<String> tokens = new ArrayList<String>();
            
            for(int i=j; i<=s.length()-tokenLen; i+= tokenLen) { //tokenize
                tokens.add(s.substring(i, i+tokenLen));
            }
            for(int i=0; i<=tokens.size()-words.length; i++) {
                if( i == 0) {
                    for(int k=0; k < words.length; k++) {
                        String temp = tokens.get(k);
                        if( dict.containsKey(temp) )
                            dict.put(temp, dict.get(temp)+1);
                        else
                            dict.put(temp, 1);
                    }
                }
                else {
                    String pop = tokens.get(i-1);
                    String push = tokens.get(i-1+words.length);
                    if( push != pop) {
                        dict.put(pop, dict.get(pop)-1);
                        if( dict.get(pop) == 0)
                            dict.remove(pop);
                        if( dict.containsKey(push) )
                            dict.put(push, dict.get(push)+1);
                        else
                            dict.put(push, 1);
                    }
                }
                if( wordDict.size() != dict.size() )
                    continue;
                boolean conFlag = false;
                for( String key: wordDict.keySet() ) {
                    if( wordDict.get(key) != dict.get(key) ) {
                        conFlag = true;
                        break;
                    }
                }
                if( conFlag )
                    continue;
                ans.add(j+i*tokenLen);
            }
        }
        return ans;
    }
}