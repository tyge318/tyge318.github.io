public class Solution {
    public int totalNQueens(int n) {
        List<List<Integer>> ans = generate(0, n, (new ArrayList<List<Integer>>() ) );
        return ans.size();
    }
    public List<List<Integer>> generate(int pos, int n, List<List<Integer>> last) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( last.isEmpty() )
            last.add( new ArrayList<Integer>() );
        for(int i=0; i<last.size(); i++) {
            for(int j=0; j<n; j++) {
                List<Integer> current = new ArrayList<Integer>(last.get(i));
                current.add(j);
                if( check(current, n) )
                    ans.add(current);
            }
        }
        if( pos == n-1)
            return ans;
        else
            return generate(pos+1, n, ans);
    }
    public boolean check(List<Integer> indices, int n) {
        boolean[] flag = new boolean[n];
        flag[indices.get(0)] = true;
        for(int i=1; i<indices.size(); i++) {
            if( flag[indices.get(i)] == true ) //same col
                return false;
            else
                flag[indices.get(i)] = true;
            for(int j=0; j<i; j++) {
                if( Math.abs(indices.get(i) - indices.get(j) ) == i-j) //diagonal
                    return false;
            }
        }
        return true;
    }
}