public class Solution {
    public int countSegments(String s) {
        String[] tokens = s.split("\\s+");
        int ans = tokens.length;
        if( ans == 0)
            return 0;
        if( tokens[0].isEmpty() )
            ans--;
        if( tokens.length == 1)
            return ans;
        if( tokens[tokens.length-1].isEmpty())
            ans--;
        return ans;
    }
}