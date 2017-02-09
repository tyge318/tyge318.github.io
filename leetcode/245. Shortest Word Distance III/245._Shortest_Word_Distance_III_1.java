public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int cache = -1, ans = words.length;
        for(int i=0; i<words.length; i++) {
            if( words[i].equals(word1) || words[i].equals(word2) ) {
                if( cache != -1 && (word1.equals(word2) || !words[cache].equals(words[i]) ) ) {
                    ans = Math.min(i-cache, ans);
                }
                cache = i;
            }
        }
        return ans;
    }
}