public class Solution {
    public int firstUniqChar(String s) {
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( s.lastIndexOf(cc) == s.indexOf(cc) )
                return i;
        }
        return -1;
    }
}