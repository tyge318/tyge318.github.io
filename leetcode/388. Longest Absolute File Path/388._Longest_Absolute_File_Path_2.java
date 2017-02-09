public class Solution {
    public int lengthLongestPath(String input) {
        Stack<String> st = new Stack<String>();
        
        //System.out.println("input:\n "+input);
        int ans = 0;
        input = input.replaceAll(" {4}+", "\t");
        String[] tokens = input.split("\n");
        int lastLayer = 0;
        for(String s: tokens) {
            int layer = countTab(s);
            //System.out.println("s = " + s + "; layer = " + layer);
            s = s.replaceAll("\t+", "");
            //System.out.println("s = " + s + "; layer = " + layer);
            if( st.empty() || layer > lastLayer) {
                int diff = layer - lastLayer;
                if( diff <= 1)
                    st.push(s);
                else {
                    for(int i=0; i<diff-1; i++)
                        s = "    "+s;
                    st.push(s);
                    //System.out.println("@"+s);
                    layer = lastLayer+1;
                }
            }
            else if( layer == lastLayer) {
                String top = st.peek();
                if( top.contains(".") ) {
                    String pathString = st.toString();
                    //System.out.println("1.pathString = " + pathString);
                    int pathLength = pathString.length()-2-(st.size()-1);
                    ans = Math.max(ans, pathLength);
                }
                st.pop();
                st.push(s);
            }
            else {  //layer < lastLayer
                String top = st.peek();
                if( top.contains(".") ) {
                    String pathString = st.toString();
                    //System.out.println("2.pathString = " + pathString);
                    int pathLength = pathString.length()-2-(st.size()-1);
                    ans = Math.max(ans, pathLength);
                }
                for(int i=0; i<(lastLayer-layer)+1; i++)
                    st.pop();
                st.push(s);
            }
            lastLayer = layer; 
        }
        String top = st.peek();
        if( top.contains(".") ) {
            String pathString = st.toString();
            //System.out.println("3.pathString = " + pathString);
            int pathLength = pathString.length()-2-(st.size()-1);
            ans = Math.max(ans, pathLength);
        }
        return ans;
    }
    public int countTab(String s) {
        //StringBuilder temp = new StringBuilder();
        int counter = 0;
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == '\t' )
                counter++;
        }
        return counter;
    }
}