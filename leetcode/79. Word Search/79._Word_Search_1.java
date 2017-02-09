public class Solution {
    int[] vi = {-1, 1, 0, 0};
    int[] vj = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] mark = new boolean[row][col];
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                if( walk(board, mark, i, j, 0, word) )
                    return true;
        return false;
    }
    
    public boolean walk(char[][] board, boolean[][] mark, int i, int j, int k, String word) {
        int row = board.length, col = board[0].length;
        if( i < 0 || i >=row || j < 0 || j >= col || mark[i][j] || board[i][j] != word.charAt(k) )
            return false;
        if( ++k == word.length() )
            return true;
        mark[i][j] = true;
        for(int m=0; m<4; m++) {
            if( walk(board, mark, i+vi[m], j+vj[m], k, word) )
                return true;
        }
        mark[i][j] = false;
        return false;
    }

}