public class Solution {
    public String shortestPalindrome(String s) {
        int begin = 0, end = s.length()-1;
        while( end >= 0) {
            if( s.charAt(begin) == s.charAt(end) )
                begin++;
            end--;
        }
        if( begin == s.length())
            return s;
        
        String tail = s.substring(begin);
        String pre = (new StringBuilder(tail)).reverse().toString();
        return pre+shortestPalindrome(s.substring(0, begin))+tail;
    }
}