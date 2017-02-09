public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( numRows == 0) return ans;
        ans.add(new ArrayList(Arrays.asList(1)) );
        for(int i=1; i<numRows; i++) {
            List<Integer> suban = new ArrayList<Integer>();
            int count = i+1;
            for(int j=0; j<count; j++) {
                int a = (j-1 < 0) ? 0 : ans.get(i-1).get(j-1);
                int b = (j == count-1) ? 0: ans.get(i-1).get(j);
                suban.add(a+b);
            }
            ans.add(suban);
        }
        return ans;
    }
}