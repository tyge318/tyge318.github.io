public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> strToPattern = new HashMap<>();
        Map<Character, String> patternToStr = new HashMap<>();
        String[] tokens = str.split(" ");
        if( tokens.length != pattern.length() )
            return false;
        for(int i=0; i<tokens.length; i++) {
            if( !strToPattern.containsKey(tokens[i]) && !patternToStr.containsKey(pattern.charAt(i)) ) {
                strToPattern.put(tokens[i], pattern.charAt(i) );
                patternToStr.put(pattern.charAt(i), tokens[i] );
            }
            else if( strToPattern.containsKey(tokens[i]) && patternToStr.containsKey(pattern.charAt(i) ) && strToPattern.get(tokens[i]) == pattern.charAt(i) )
                continue;
            else
                return false;
        }
        return true;
    }
}