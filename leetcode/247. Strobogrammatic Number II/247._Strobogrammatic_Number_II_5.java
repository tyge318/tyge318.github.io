public class Solution {
    String[] list = {"00", "11", "69", "88", "96"};
    int cut = 0;
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = recursion(n);
        return ans.subList(cut, ans.size());
    }
    public List<String> recursion(int n) {
        List<String> ans = new ArrayList<String>();
        if( n == 1 ) {
            ans = new ArrayList<String>(Arrays.asList("0", "1", "8"));
            return ans;
        }
        if( n == 2 ) {
            cut = 1;
            ans = new ArrayList<String>(Arrays.asList(list));
            return ans;
        }
        List<String> middles = recursion(n-2);
        cut = Math.max(cut, middles.size());
        for(String s: list) {
            for(String ss: middles) {
                ans.add(s.substring(0, 1)+ss+s.substring(1));
            }
        }
        return ans;
    }
}