public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), 2, n);
        return ans;
    }
    public void dfs(List<List<Integer>> ans, List<Integer> temp, int begin, int n) {
        if( n <= 1 ) {
            if( temp.size() > 1 ) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        for(int i=begin; i*i<=n; i++) {
            if( n % i != 0) continue;
            temp.add(i);
            dfs(ans, temp, i, n/i);
            temp.remove(temp.size()-1);
        }
        temp.add(n);
        dfs(ans, temp, n, 1);
        temp.remove(temp.size()-1);
    }
}