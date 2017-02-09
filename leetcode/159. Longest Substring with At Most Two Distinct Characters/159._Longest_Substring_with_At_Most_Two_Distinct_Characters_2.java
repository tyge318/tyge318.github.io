public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> trace = new HashMap<Character, Integer>();
        if(s.length() <= 2)
            return s.length();
        int begin = 0, ans = 0;
        s += "#";
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( !trace.containsKey(cc) ) {
                if( trace.size() == 2 ) { //if reach limit
                    ans = Math.max(ans, i-begin);   //record previous length
                    while( begin < i && trace.size() == 2) {
                        char bc = s.charAt(begin++);
                        int temp = trace.get(bc);
                        temp--;
                        if( temp == 0 )
                            trace.remove(bc);
                        else
                            trace.put(bc, temp);
                    }
                }
                trace.put(cc, 1);
            }
            else {
                trace.put(cc, trace.get(cc)+1);
            }
        }
        return (ans == 0) ? s.length()-1: ans;
    }
}