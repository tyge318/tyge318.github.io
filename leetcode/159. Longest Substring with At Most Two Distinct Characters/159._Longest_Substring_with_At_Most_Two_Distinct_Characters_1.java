public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if( s.length() <= 2)    return s.length();
        Map<Character, Integer> count = new HashMap<>();
        int begin = 0, ans = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if( !count.containsKey(c) )
                count.put(c, 1);
            else
                count.put(c, count.get(c)+1);
            while( count.size() > 2) {
                char rc = s.charAt(begin++);
                count.put(rc, count.get(rc)-1);
                if( count.get(rc) == 0)
                    count.remove(rc);
            }
            ans = Math.max(ans, i-begin+1);
        }
        return ans;
    }
}