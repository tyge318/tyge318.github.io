public class Solution {
    public int strStr(String haystack, String needle) {
        int needle_len = needle.length();
        int haystack_len = haystack.length();
        if( haystack_len == needle_len && haystack_len == 0)
            return 0;
        for(int i=0; i<=(haystack_len - needle_len); i++) {
            String substring = haystack.substring(i, i+needle_len);
            if( needle.equals(substring) )
                return i;
        }
        return -1;
    }
}