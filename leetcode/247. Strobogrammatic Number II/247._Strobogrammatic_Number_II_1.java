public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<List<String>> opt = new ArrayList<>();
        opt.add(new ArrayList<>(Arrays.asList("")));
        opt.add(new ArrayList<String>(Arrays.asList("0", "1", "8")) );
        opt.add(new ArrayList<String>(Arrays.asList("00", "11", "69", "88", "96")) );
        if( n <= 1 )    return opt.get(n);
        for(int i=3; i<=n; i++) {
            opt.add(new ArrayList<>());
            for(String s1: opt.get(2)) {
                for(String s2: opt.get(i-2)) {
                    opt.get(i).add(s1.substring(0, 1)+s2+s1.substring(1));
                }
            }
        }
        int begin = opt.get(n-2).size(), end = opt.get(n).size();
        List<String> ans = opt.get(n).subList(begin, end);
        return ans;
    }
}