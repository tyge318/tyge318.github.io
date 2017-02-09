public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == '(' || cc == '{' || cc == '[' ) {
                st.push(cc);
            }
            else {
                if( st.empty() )
                    return false;
                if( cc == ')' ) {
                    if(st.peek().charValue() == '(') {
                        st.pop();
                        continue;
                    }
                    else
                        return false;
                }
                else if (cc == '}') {
                    if( st.peek().charValue() == '{') {
                        st.pop();
                        continue;
                    }
                    else
                        return false;
                }
                else {
                    if( st.peek().charValue() == '[') {
                        st.pop();
                        continue;
                    }
                    else
                        return false;
                }
            }
        }
        if( st.empty() )
            return true;
        else
            return false;
    }
}