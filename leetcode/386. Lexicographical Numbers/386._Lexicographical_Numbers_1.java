public class Solution {
    int n;
    List<Integer> ans;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        ans = new ArrayList<Integer>();
        for(int i=1; i<=9; i++) {
            generate(i);
        }
        return ans;
    }
    public void generate(int k) {
        if( k > n) return;
        ans.add(k);
        for(int i=0; i<=9; i++) {
            generate(k*10+i);
        }
    }
}