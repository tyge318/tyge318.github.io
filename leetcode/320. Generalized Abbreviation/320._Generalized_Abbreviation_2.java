public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<String>();
        dfs(ans, word, 0, "", 0);
        return ans;
    }
    public void dfs(List<String> ans, String word, int i, String current, int count) {
        if( i == word.length() ) {
            if( count > 0 )
                current += count;
            ans.add(current);
            return;
        }
        //abbreviate, need to increment the count
        dfs(ans, word, i+1, current, count+1);
        //keep, need to reset the count
        dfs(ans, word, i+1, current + (count > 0? count: "") + word.charAt(i), 0);
    }
}