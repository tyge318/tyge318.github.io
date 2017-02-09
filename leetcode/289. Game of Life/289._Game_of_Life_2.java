public class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = (m == 0) ? 0: board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = count(board, i, j);
                if( (count == 2 && board[i][j] == 1) || count == 3)
                    board[i][j] += 10;
            }
        }
        update(board);
    }
    public void update(int[][] board) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
                board[i][j] /= 10;
        }
    }
    public int count(int[][] board, int i, int j) {
        int[] step = {-1, 0, 1};
        int count = 0;
        for(int di=0; di<3; di++) {
            for(int dj=0; dj<3; dj++) {
                if( step[di] == 0 && step[dj] == 0 )
                    continue;
                if( i+step[di] < 0 || i+step[di] >= m )
                    continue;
                if( j+step[dj] < 0 || j+step[dj] >= n )
                    continue;
                count += (board[i+step[di]][j+step[dj]] % 10);
            }
        }
        return count;
    }
}