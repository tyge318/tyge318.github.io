public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            if( rowChecker(board, i) == false)
                return false;
            if( colChecker(board, i) == false)
                return false;
            if( cellChecker(board, i) == false)
                return false;
        }
        return true;
    }
    public boolean rowChecker(char[][] board, int row) {
        int[] mark = new int[10];
        for(int i=0; i<9; i++) {
            if(board[row][i] == '.' )
                continue;
            int curNum = board[row][i] - '0';
            mark[curNum]++;
            if(mark[curNum] > 1) {
                System.out.println("Row check fail:" + row);
                return false;
            }
        }
        return true;
    }
    public boolean colChecker(char[][] board, int col) {
        int[] mark = new int[10];
        for(int i=0; i<9; i++) {
            if(board[i][col] == '.')
                continue;
            int curNum = board[i][col] - '0';
            mark[curNum]++;
            if(mark[curNum] > 1) {
                System.out.println("Col check fail:" + col);
                return false;
            }
        }
        return true;
    }
    public boolean cellChecker(char[][] board, int cell) {
        int row = 0, col = 0;
        switch(cell) {
            case 0:
                break;
            case 1:
                col = 3;
                break;
            case 2:
                col = 6;
                break;
            case 3:
                row = 3;
                break;
            case 4:
                row = 3;
                col = 3;
                break;
            case 5:
                row = 3;
                col = 6;
                break;
            case 6:
                row = 6;
                break;
            case 7:
                row = 6;
                col = 3;
                break;
            case 8:
                row = 6;
                col = 6;
                break;
        }
        int[] mark = new int[10];
        for(int i=row; i<row+3; i++) {
            for(int j=col; j<col+3; j++) {
                if(board[i][j] == '.')
                    continue;
                int curNum = board[i][j] - '0';
                mark[curNum]++;
                if(mark[curNum] > 1) {
                    System.out.println("Cell check fail:" + cell);
                    return false;
                }
            }
        }
        return true;
    }
}