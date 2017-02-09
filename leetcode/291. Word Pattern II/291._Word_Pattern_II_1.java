public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> patternToString = new HashMap<>();
        Set<String> existing = new HashSet<>();
        return dfs(pattern, 0, str, 0, patternToString, existing);
    }
    public boolean dfs(String pattern, int pi, String str, int si, Map<Character, String> patternToString, Set<String> existing) {
        if( pi == pattern.length() && si == str.length())   return true;
        if( pi == pattern.length() || si == str.length())   return false;
        
        char current = pattern.charAt(pi);
        if( patternToString.containsKey(current) ) {
            String s = patternToString.get(current);
            if( !str.startsWith(s, si) )    return false;
            return dfs(pattern, pi+1, str, si+s.length(), patternToString, existing);
        }
        
        for(int k = si+1; k<=str.length(); k++) {
            String s = str.substring(si, k);
            if( existing.contains(s) )  continue;
            patternToString.put(current, s);
            existing.add(s);
            if( dfs(pattern, pi+1, str, k, patternToString, existing) )
                return true;
            patternToString.remove(current);
            existing.remove(s);
        }
        return false;
    }
}