public class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int r = n-k;
        if( r <= 0 )
            return "0";
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<n; i++) {
            while( !st.empty() && st.peek() > num.charAt(i) && st.size()+(n-i) > r )
                st.pop();
            st.push(num.charAt(i));
        }
        if( st.size() > r)
            st.pop();
        //System.out.println("st = " + st.toString());
        StringBuilder temp = new StringBuilder();
        while( temp.length() < r) {
            temp.append(st.pop());
        }
        //remove leading zeros
        while( temp.length() > 0 && temp.charAt(temp.length()-1) == '0')
            temp.deleteCharAt(temp.length()-1);
        String ans = (temp.length() > 0) ? temp.reverse().toString() : "0";
        return ans;
    }
}