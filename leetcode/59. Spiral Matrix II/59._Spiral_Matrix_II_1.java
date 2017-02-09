public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if( n == 0)
            return matrix;
        int left = -1, right = n, top = -1, down = n;
        int counter = 1, dir = 0, i = 0, j = 0; 
        /* 0: right, 1: down, 2:left, 3:up */
        while( counter <= n*n) {
            matrix[i][j] = counter;
            counter++;
            switch( dir ) {
                case 0:
                    j++;
                    if( j == right) {
                        j--;
                        i++;
                        top++;
                        dir++;
                    }
                    break;
                case 1:
                    i++;
                    if( i == down) {
                        i--;
                        j--;
                        right--;
                        dir++;
                    }
                    break;
                case 2:
                    j--;
                    if( j == left) {
                        j++;
                        i--;
                        down--;
                        dir++;
                    }
                    break;
                case 3:
                    i--;
                    if( i == top) {
                        i++;
                        j++;
                        left++;
                        dir = 0;
                    }
                    break;
            }
        }
        return matrix;
    }
}