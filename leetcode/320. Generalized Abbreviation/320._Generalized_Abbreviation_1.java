public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", word, 0, 0);
        return ans;
    }
    public void dfs(List<String> ans, String current, String s, int i, int count) {
        if( i == s.length() ) {
            if( count > 0 )
                current += count;
            ans.add(current);
            return;
        }
        //abbreviate
        dfs(ans, current, s, i+1, count+1);
        //not abbreviate
        dfs(ans, current+(count == 0 ? "":count)+s.charAt(i), s, i+1, 0);
    }
}