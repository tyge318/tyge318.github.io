public class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = (m == 0) ? 0: board[0].length;
        for(int i=0; i<m; i++)  {
            for(int j=0; j<n; j++) {
                int count = countNeighbor(board, i, j);
                int current = board[i][j] % 10;
                if( current == 1)
                    if( (count == 2 || count == 3) && board[i][j]-1 != 10)  board[i][j] += 10;
                if( current == 0)
                    if( count == 3 && board[i][j] != 10)    board[i][j] += 10;
            }
        }
        update(board);
    }
    public void update(int[][] board) {
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                board[i][j] /= 10;
    }
    public int countNeighbor(int[][] board, int row, int col) {
        int count = 0;
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                if( i == 0 && j == 0)   continue;
                if( row+i < 0 || row+i >= m || col+j < 0 || col+j >= n )    continue;
                count += (board[row+i][col+j] % 10);
            }
        }
        return count;
    }
}