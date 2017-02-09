public class Solution {
    public void solveSudoku(char[][] board) {
        solve(0, board);
    }
    public boolean solve(int n, char[][] board) {
        if( n == 81)
            return true;
        int row = n/9, col = n%9;
        if( board[row][col] != '.')
            return solve(n+1, board);
        for(int i=0; i<9; i++) {
            board[row][col] = (char)((int)'1' + i);
            if( isValid(row, col, board) && solve(n+1, board) )
                return true;
            board[row][col] = '.';
        }
        return false;
    }
    public boolean isValid(int row, int col, char[][] board) {
        //check row
        for(int i=0; i<9; i++) {
            if( i == col )
                continue;
            if( board[row][i] == board[row][col])
                return false;
        }
        //check col
        for(int i=0; i<9; i++) {
            if( i == row)
                continue;
            if( board[i][col] == board[row][col])
                return false;
        }
        //check block
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int tr = (row/3)*3+i, tc = (col/3)*3+j;
                if( tr == row && tc == col)
                    continue;
                if( board[tr][tc] == board[row][col])
                    return false;
            }
        }
        return true;
    }
}