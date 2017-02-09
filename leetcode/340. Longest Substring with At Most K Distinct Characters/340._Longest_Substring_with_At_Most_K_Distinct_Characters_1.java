public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if( s == null || s.isEmpty())
            return 0;
        if( s.length() <= k)
            return s.length();
            
        int begin = 0, ans = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if( !counts.containsKey(c) )
                counts.put(c, 1);
            else
                counts.put(c, counts.get(c)+1);
            while( counts.size() > k ) {
                char beginChar = s.charAt(begin++);
                counts.put(beginChar, counts.get(beginChar)-1);
                if( counts.get(beginChar) == 0 )
                    counts.remove(beginChar);
            }
            ans = Math.max(ans, i-begin+1);
        }
        return ans;
    }
}