public class Solution {
    int m, n;
    public int minTotalDistance(int[][] grid) {
        m = grid.length;
        n = (m == 0) ? 0: grid[0].length;
        
        List<Integer> Xs = new ArrayList<>();
        List<Integer> Ys = new ArrayList<>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] == 1)
                    Xs.add(i);
            }
        }
        for(int j=0; j<n; j++) {
            for(int i=0; i<m; i++) {
                if( grid[i][j] == 1)
                    Ys.add(j);
            }
        }
        return balancing(Xs) + balancing(Ys);
    }
    public int balancing(List<Integer> list) {
        int sum = 0, i = 0, j = list.size()-1;
        while( i < j) {
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }
}