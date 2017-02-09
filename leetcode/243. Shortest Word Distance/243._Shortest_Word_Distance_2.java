public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, ans = words.length;
        for(int i=0; i<words.length; i++) {
            if( words[i].equals(word1) )
                p1 = i;
            if( words[i].equals(word2) )
                p2 = i;
            if( p1 != -1 && p2 != -1)
                ans = Math.min(ans, Math.abs(p1-p2) );
        }
        return ans;
    }
}