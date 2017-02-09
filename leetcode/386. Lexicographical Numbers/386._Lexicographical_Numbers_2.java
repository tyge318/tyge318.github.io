public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=1; i<=9; i++) {
            generate(ans, 0, i, n);
        }
        return ans;
    }
    public void generate(List<Integer> ans, int prefix, int k, int n) {
        prefix = prefix*10+k;
        if( prefix > n) return;
        ans.add(prefix);
        for(int i=0; i<=9; i++) {
            generate(ans, prefix, i, n);
        }
    }
}