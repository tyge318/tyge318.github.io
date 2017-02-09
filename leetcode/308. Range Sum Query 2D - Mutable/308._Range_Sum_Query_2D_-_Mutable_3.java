public class NumMatrix {
    int[][] matrix;
    int[][] rowSum;
    int m, n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = (m == 0 ) ? 0 : matrix[0].length;
        if( m == 0 || n == 0)
            return;
        this.matrix = matrix;
        rowSum = new int[m][n];
        //rowSum[i][j] = matrix[i][0] + ... + matrix[i][j]
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( j == 0)
                    rowSum[i][j] = matrix[i][j];
                else
                    rowSum[i][j] = matrix[i][j] + rowSum[i][j-1];
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i=col; i<n; i++) {
            rowSum[row][i] -= matrix[row][col];
            rowSum[row][i] += val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i=row1; i<= row2; i++) {
            ans += (rowSum[i][col2] - ((col1 == 0) ? 0: rowSum[i][col1-1]));
        }
        return ans;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);