public class NumMatrix {
    int[][] array;
    int m, n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = (m == 0) ? 0 : matrix[0].length;
        array = new int[m][n];
        for(int i=0; i<m; i++) {
            array[i][0] = matrix[i][0];
            for(int j=1; j<n; j++) {
                array[i][j] = array[i][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2; i++) {
            sum += (array[i][col2] - ((col1 == 0) ? 0: array[i][col1-1]) );
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);