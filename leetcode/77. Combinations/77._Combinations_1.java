public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( n == k) {
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=1; i<=n; i++)
                temp.add(i);
            ans.add(temp);
            return ans;
        }
        else if( k == 0 ) {
            ans.add(Arrays.asList());
            return ans;
        }
        else if( k == 1) {
            for(int i=1; i<=n; i++)
                ans.add(new ArrayList<Integer>(Arrays.asList(i)) );
            return ans;
        }
        List<List<Integer>> sub1 = combine(n-1, k-1);
        Iterator<List<Integer>> itr = sub1.iterator();
        while( itr.hasNext() ) {
            List<Integer> current = itr.next();
            current.add(n);
            ans.add(current);
        }
        ans.addAll(combine(n-1, k));
        return ans;
    }
}