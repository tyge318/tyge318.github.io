public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = (m == 0) ? 0: matrix[0].length;
        if( m == 0)
            return false;
        int i = 0, j = n-1;
        while( j >= 0 && i < m ) {
            if( target == matrix[i][j] )    
                return true;
            else if( target > matrix[i][j] ) //greater than the max of this row, can't be at this row
                i++;
            else if( target < matrix[i][j] ) //greater than the min of this col, can't be at this col
                j--;
        }   
        return false;
    }
}