import java.math.BigInteger;

public class Solution {
    public void setZeroes(int[][] matrix) {
        BigInteger rowID = BigInteger.ZERO, colID = BigInteger.ZERO;
        
        int row = matrix.length, col = matrix[0].length;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if( matrix[i][j] == 0) {
                    rowID = rowID.or(BigInteger.ONE.shiftLeft(i) );
                    colID = colID.or(BigInteger.ONE.shiftLeft(j) );
                }
            }
        }
        
        int counter = 0;
        while( !rowID.equals(BigInteger.ZERO) ) {
            if(rowID.testBit(0)) {
                for(int j=0; j<col; j++)
                    matrix[counter][j] = 0;
            }
            rowID = rowID.shiftRight(1);
            counter++;
        }
        counter = 0;
        while( !colID.equals(BigInteger.ZERO) ) {
            if( colID.testBit(0)) {
                for(int j=0; j<row; j++)
                    matrix[j][counter] = 0;
            }
            colID = colID.shiftRight(1);
            counter++;
        }
        
    }
}