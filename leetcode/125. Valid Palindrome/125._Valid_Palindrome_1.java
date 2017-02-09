public class Solution {
    public boolean isPalindrome(String s) {
        if( s.isEmpty() ) return true;
        s = s.toLowerCase();
        int begin = 0, end = s.length()-1;
        while( begin < end) {
            if( !(Character.isLetter(s.charAt(begin)) || Character.isDigit(s.charAt(begin))) ) {
                begin++;
                continue;
            }
            if( !(Character.isLetter(s.charAt(end)) || Character.isDigit(s.charAt(end))) ) {
                end--;
                continue;
            }
            //System.out.println("s[" + begin + "]("+s.charAt(begin)+") ?= s[" + end + "]("+s.charAt(end)+")");
            if( s.charAt(begin) != s.charAt(end) ) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}