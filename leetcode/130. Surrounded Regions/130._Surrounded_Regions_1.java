public class Solution {
    int m, n;
    public void solve(char[][] board) {
        if(board.length == 0)
            return;
        m = board.length;
        n = board[0].length;
        //left boarder and right boarder
        for(int i=0; i<m; i++) {
            if( board[i][0] == 'O')
                merge(board, i, 0);
        }
        for(int i=0; i<m; i++) {
            if( board[i][n-1] == 'O')
                merge(board, i, n-1);
        }
        //top boarder and botton boarder
        for(int i=0; i<n; i++) {
            if( board[0][i] == 'O')
                merge(board, 0, i);
        }
        for(int i=0; i<n; i++) {
            if( board[m-1][i] == 'O')
                merge(board, m-1, i);
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( board[i][j] == 'O')
                    board[i][j] = 'X';
                if( board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    public void merge(char[][] board, int row, int col) {
        Queue<Integer> q = new LinkedList<Integer>();
        fill(board, q, row, col);
        while( !q.isEmpty() ) {
            int current = q.poll();
            int cx = current/n, cy = current%n;
            fill(board, q, cx-1, cy);
            fill(board, q, cx+1, cy);
            fill(board, q, cx, cy-1);
            fill(board, q, cx, cy+1);
        }
    }
    public void fill(char[][] board, Queue<Integer> q, int i, int j) {
        if( i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
            return;
        q.add( i*n+j );   
        board[i][j] = '#';
    }
}