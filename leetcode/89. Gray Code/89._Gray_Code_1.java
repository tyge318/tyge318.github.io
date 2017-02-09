public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>(Arrays.asList(0));
        if( n == 0)
            return ans;
        ans.add(1);
        if( n == 1)
            return ans;
        for(int i=1; i<n; i++) {
            List<Integer> temp = new ArrayList<Integer>(ans);
            for(int j=ans.size()-1; j>=0; j--)
                temp.add( ((1<<i)|ans.get(j)) );
            ans = temp;
        }
        return ans;
    }
}