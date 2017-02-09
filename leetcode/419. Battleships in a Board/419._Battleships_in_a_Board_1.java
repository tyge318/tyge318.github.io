public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = (m == 0) ? 0: board[0].length;
        //int[][] mark  = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( board[i][j] == '.')
                    continue;
                if( i-1 >= 0 && board[i-1][j] == 'X' ) {
                    //mark[i][j] = mark[i-1][j];
                    continue;
                }
                if( j-1 >= 0 && board[i][j-1] == 'X' ) {
                    //mark[i][j] = mark[i][j-1];
                    continue;
                }
                //mark[i][j] = ++count;
                ++count;
            }
        }
        //System.out.println(Arrays.deepToString(mark));
        return count;
    }
}