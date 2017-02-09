public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int Am = A.length, An = A[0].length, Bm = B.length, Bn = B[0].length;
        int[][] C = new int[Am][Bn];
        for(int i=0; i<Am; i++) {
            for(int j=0; j<An; j++) {
                if( A[i][j] == 0)   continue;
                for(int k=0; k<Bn; k++) {
                    if( B[j][k] == 0)   continue;
                    C[i][k] += A[i][j]*B[j][k];
                }
            }
        }
        return C;
    }
}