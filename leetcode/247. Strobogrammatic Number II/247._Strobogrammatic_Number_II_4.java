public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = helper(n);
        if( n <= 1 )    return ans;
        Iterator<String> itr = ans.iterator();
        while( itr.hasNext()) {
            if( itr.next().startsWith("0") )
                itr.remove();
        }
        return ans;
    }
    public List<String> helper(int n) {
        List<String> ans = new ArrayList<String>();
        if( n == 0) return ans;
        if( n == 1)
            return (new ArrayList<String>(Arrays.asList("0", "1", "8")) );
        if( n == 2)
            return (new ArrayList<String>(Arrays.asList("00", "11", "69", "88", "96")) );
        List<String> middle = helper(n-2);
        List<String> headTail = helper(2);
        for(String s1: headTail) {
            for(String s2: middle) {
                StringBuilder sb = new StringBuilder(s1);
                sb.insert(1, s2);
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}