public class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> temp = new HashSet();
        temp = generate(n, 0, temp);
        List<String> ans = new ArrayList<String>(temp);
        return ans;
    }
    public Set<String> generate(int n, int current, Set<String> last) {
        Set<String> ans = new HashSet<String>();
        if( current == 0 ) {
            ans.add("()");
        }
        else {
            Iterator<String> itr = last.iterator();
            while(itr.hasNext()) {
                String temp = itr.next();
                ans.addAll(insertToAllPositions(temp) );
            }
        }
        if (current == n-1) {
            return ans;
        }
        else {
            return generate(n, current+1, ans);
        }
    }
    public Set<String> insertToAllPositions(String input) {
        Set<String> ans = new HashSet<String>();
        for(int i=0; i<=input.length(); i++) {
            StringBuilder temp = new StringBuilder(input);
            temp.insert(i, "()");
            ans.add(temp.toString());
        }
        return ans;
    }
}