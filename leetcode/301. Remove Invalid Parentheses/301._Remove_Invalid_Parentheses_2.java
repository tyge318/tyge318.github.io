public class Solution {
    List<String> ans;
    public List<String> removeInvalidParentheses(String s) {
        ans = new ArrayList<String>();
        remove(s, ')', 0);
        return ans;
    }
    public void remove(String s, char target, int lastIndex) {
        for(int i=0, count = 0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == '(' || cc == ')') //count only '(' or ')'
                count += ( (cc == target) ? 1: -1);  //matching
            if(count <= 0)  //perfectly matched or extra target, take care of that later.
                continue;
            for(int j=lastIndex; j<=i; j++) { //search from lastIndex beyond
                char scc = s.charAt(j);
                //not consecutive targets unless the first (lastIndex) one
                if( scc == target && (j == lastIndex || s.charAt(j-1) != target) ) 
                    remove(s.substring(0, j)+s.substring(j+1), target, j);
            }
            return;
        }
        s = (new StringBuilder(s)).reverse().toString();
        if( target == ')') {
            remove(s, '(', 0);
            return;
        }
        //if passed checkings from two directions, it's valid.
        ans.add(s);
    }
}
