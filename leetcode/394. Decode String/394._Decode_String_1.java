public class Solution {
    public String decodeString(String s) {
        //StringBuilder ans = new StringBuilder();
        Stack<String> st = new Stack<String>();
        Stack<Integer> numSt = new Stack<Integer>();
        
        StringBuilder temp = new StringBuilder();;
        for(int i=0; i<s.length(); i++) {
            String cc = s.substring(i, i+1);
            if( cc.matches("\\d") ) {
                if( temp.length() == 0 || (temp.charAt(0) >= '0' && temp.charAt(0) <= '9') )
                    temp.append(cc);
                else{
                    if( numSt.empty() ) {
                        String prefix = (st.empty()) ? "": st.pop();
                        st.push(prefix+temp.toString());
                    }
                    else
                        st.push(temp.toString());
                    temp.delete(0, temp.length());
                    temp.append(cc);
                }
            }
            else if ( cc.matches("[a-zA-Z]") ) {
                temp.append(cc);
            }
            else {
                if( cc.equals("[") ) {
                    numSt.push(Integer.valueOf(temp.toString()));
                    temp.delete(0, temp.length());
                }
                else {
                    int time = numSt.pop();
                    String seed = (temp.length() != 0) ? temp.toString() : st.pop();
                    temp.delete(0, temp.length());
                    for(int j=0; j<time; j++)
                        temp.append(seed);
                    String prefix = (st.empty()) ? "": st.pop();
                    st.push(prefix+temp.toString());
                    temp.delete(0, temp.length());
                }
            }
        }
        String ans = (st.empty()) ? "": st.pop();
        ans += temp.toString();
        return ans;    
    }
}