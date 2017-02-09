public class Solution {
    Map<String, Boolean> cache;
    public boolean canWin(String s) {
        if( s.length() < 2)
            return false;
        cache = new HashMap<String, Boolean>();
        return check(s);
    }
    public boolean check(String s) {
        if( cache.containsKey(s) )
            return cache.get(s);
        StringBuilder sb;
        for(int i=0; i<s.length()-1; i++) {
            sb = new StringBuilder(s);
            if( sb.charAt(i) == '+' && sb.charAt(i+1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i+1, '-');
                if( !check(sb.toString()) ) {
                    cache.put(s, true);
                    return true;
                }
            }
        }
        return false;
    }
}