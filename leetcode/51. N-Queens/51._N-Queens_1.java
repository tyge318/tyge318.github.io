public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> ans = generate(0, n, (new ArrayList<List<Integer>>() ) );
        List<List<String>> out = new ArrayList<List<String>>();
        
        for(int i=0; i<ans.size(); i++) {
            List<String> current = new ArrayList<String>();
            //System.out.println("solution <" + i + ">: " + ans.get(i).toString() );
            for(int j=0; j<n; j++) {
                current.add( translate(ans.get(i).get(j), n) );
            }
            out.add(current);
        }
        return out;
    }
    public String translate(int pos, int n) {
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<n; i++)
            temp.append( ((i == pos) ? 'Q' : '.') );
        return temp.toString();
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