public class Solution {
    public String parseTernary(String expression) {
        StringBuilder st = new StringBuilder();
        for(int i=expression.length()-1; i>=0; i--) {
            char c = expression.charAt(i);
            st.append(c);
            while( canEval(st) ) {
                String ss = st.substring(st.length()-5);
                st.delete(st.length()-5, st.length());
                if( ss.charAt(4) == 'T')
                    st.append(ss.charAt(2));
                else
                    st.append(ss.charAt(0));
            }
        }
        return st.toString();
    }
    public boolean canEval(StringBuilder st) {
        if( st.length() < 5)
            return false;
        int n = st.length();
        if( st.charAt(n-4) == ':' && st.charAt(n-2) == '?' && (st.charAt(n-1) == 'F' || st.charAt(n-1) == 'T') )
            return true;
        return false;
    }
}