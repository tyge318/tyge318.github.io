public class Solution {
    public int longestValidParentheses(String s) {
        int[] OPT = new int[s.length()+1];
        int ans = 0;
        
        OPT[0] = 0;
        for(int i=1; i<OPT.length; i++) {
            int open = i-2-OPT[i-1];
            char cc = s.charAt(i-1);
            if( cc == '(' || open < 0 || s.charAt(open) == ')')
                OPT[i] = 0;
            else {
                OPT[i] = OPT[i-1] + 2 + OPT[open];
                ans = Math.max(ans, OPT[i]);
            }
        }
        return ans;
    }
}