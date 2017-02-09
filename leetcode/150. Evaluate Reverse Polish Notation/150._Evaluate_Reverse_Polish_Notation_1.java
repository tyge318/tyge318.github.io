public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Long> st = new Stack<Long>();
        for(int i=0; i<tokens.length; i++) {
            if( tokens[i].matches("[-]?\\d+") ) {
                st.push(Long.valueOf(tokens[i]) );
            }
            else {
                long b = st.pop();
                long a = st.pop();
                if( tokens[i].equals("+") )
                    st.push(a+b);
                else if( tokens[i].equals("-") )
                    st.push(a-b);
                else if( tokens[i].equals("*") )
                    st.push(a*b);
                else if( tokens[i].equals("/") )
                    st.push(a/b);
                else;
            }
        }
        int ans = st.pop().intValue();
        return ans;
    }
}