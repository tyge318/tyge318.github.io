public class Solution {
    public String minWindow(String s, String t) {
        int[] tcount = new int[255];
        for(int i=0; i<t.length(); i++) {
            tcount[t.charAt(i)]++;
        }
        int start = 0, len = 0;
        int[] scount = new int[255];
        int begin = -1, end = s.length(), minLen = s.length();
        for(int i=0; i<s.length(); i++) {
            scount[s.charAt(i)]++;
            if( scount[s.charAt(i)] <= tcount[s.charAt(i)] )
                len++;
            if( len == t.length() ) {
                while( start < i && scount[s.charAt(start)] > tcount[s.charAt(start)] ) {
                    scount[s.charAt(start)]--;
                    start++;
                }
                if( i-start < minLen ) {
                    begin = start;
                    end = i;
                    minLen = i-start;
                }
                scount[s.charAt(start)]--;
                start++;
                len--;
            }
        }
        if( begin == -1)
            return "";
        else
            return s.substring(begin, end+1);
    }
}