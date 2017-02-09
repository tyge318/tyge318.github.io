public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> trace = new HashMap<Character, Integer>();
        int begin = 0, ans = 0;
        if( s.length() <= k)
            return s.length();
        s += "#";
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( !trace.containsKey(cc) ) {
                if( trace.size() == k) {
                    ans = Math.max(ans, (i-begin) );
                    //move begin forward
                    while( begin < i) {
                        char bc = s.charAt(begin++);
                        int count = trace.get(bc);
                        count--;
                        trace.put(bc, count);
                        if( count == 0) {
                            trace.remove(bc);
                            break;
                        }
                    }
                }
                trace.put(cc, 1);
            }
            else {
                trace.put(cc, trace.get(cc)+1);
            }
        }
        return ans;
    }
}