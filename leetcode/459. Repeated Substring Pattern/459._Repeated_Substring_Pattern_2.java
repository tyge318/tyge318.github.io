public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        for(int i=1; i<=str.length()/2; i++) {
            if( str.length() % i != 0)
                continue;
            String seed = str.substring(0, i);
            String pattern = "("+seed + ")+";
            if( str.matches(pattern) ) 
                return true;
        }
        return false;
    }
}