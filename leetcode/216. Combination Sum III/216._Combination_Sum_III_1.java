public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return recursiveSolution(k, n);
    }
    public List<List<Integer>> recursiveSolution(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        buildList(ans, (new ArrayList<Integer>()), 1, k, n);
        return ans;
    }
    public void buildList(List<List<Integer>> ans, List<Integer> last, int begin, int k, int n) {
        if( n < 0 )
            return;
        if( n == 0 && last.size() == k) {
            ans.add( new ArrayList<Integer>(last));
            return;
        }
        for(int i=begin; i<=9; i++) {
            last.add(i);
            buildList(ans, last, i+1, k, n-i);
            last.remove(last.size()-1);
        }
    }
}