public class NumMatrix {
    int m, n;
    int[][] matrix;
    int[][] rowSum;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = (m == 0) ? 0: matrix[0].length;
        this.matrix = matrix;
        rowSum = new int[m][n];
        
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
        for(int j=col; j<n; j++) {
            rowSum[row][j] -= matrix[row][col];
            rowSum[row][j] += val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i=row1; i<=row2; i++) {
            ans += (rowSum[i][col2] - (col1 == 0 ? 0: rowSum[i][col1-1]) );
        }
        return ans;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);