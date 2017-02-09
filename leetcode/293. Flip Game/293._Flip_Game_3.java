public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<String>();
        if( s.length() < 2)
            return ans;
        StringBuilder sb;
        for(int i=0; i<s.length()-1; i++) {
            sb = new StringBuilder(s);
            if( sb.charAt(i) == '+' && sb.charAt(i+1) == '+' ) {
                sb.setCharAt(i, '-');
                sb.setCharAt(i+1, '-');
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}