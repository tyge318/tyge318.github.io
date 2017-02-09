public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, start = 0, end = 0;
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for(int i=0; i<s.length(); i++) {
            String charAtI = s.substring(i, i+1);
            if( counter.containsKey(charAtI) )
                counter.put(charAtI, counter.get(charAtI) + 1);
            else
                counter.put(charAtI, 1);
            end++;
            while( counter.get(charAtI) > 1) {
                String charStart = s.substring(start, start+1);
                counter.put(charStart, counter.get(charStart)-1);
                start++;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}