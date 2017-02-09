public class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<String>();
        
        String[] tokens = path.split("/+");
        for(int i=0; i<tokens.length; i++) {
            if( tokens[i].equals(".") || tokens[i].isEmpty())
                continue;
            else if ( tokens[i].equals("..") ) {
                if( !st.isEmpty() )
                    st.pop();
            }
            else
                st.push(tokens[i]);
        }
        
        StringBuilder temp = new StringBuilder("/");
        while( !st.isEmpty() ) {
            temp.insert(1, st.pop()+"/");
        }
        if( temp.length() > 1)
            temp.deleteCharAt(temp.length()-1);
        return temp.toString();
    }
}