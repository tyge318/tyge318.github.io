public class NumMatrix {
    int m, n;
    int[][] tree;
    int[][] nums;
    
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = (m == 0) ? 0: matrix[0].length;
        if( m == 0 || n == 0)   return;
        tree = new int[m+1][n+1];
        nums = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
                update(i, j, matrix[i][j]);
        }
    }

    public void update(int row, int col, int val) {
        if( m == 0 || n == 0)   return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for(int i=row+1; i<=m; i += (i&(-i)) ) {
            for(int j=col+1; j<=n; j += (j&(-j)) ) {
                tree[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if( m == 0 || n == 0)   return 0;
        return sum(row2+1, col2+1)-sum(row1, col2+1)-sum(row2+1, col1)+sum(row1, col1);
    }
    
    public int sum(int row, int col) {
        int ans = 0;
        for(int i=row; i>0; i -= (i&(-i)) ) {
            for(int j=col; j>0; j -= (j&(-j)) ) {
                ans += tree[i][j];
            }
        }
        return ans;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);