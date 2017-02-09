public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length-1;
        for(int i=0; i<=len/2; i++) {
            int temp;
            for(int j=i; j<len-i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[len-j][i];
                matrix[len-j][i] = matrix[len-i][len-j];
                matrix[len-i][len-j] =  matrix[j][len-i];
                matrix[j][len-i] = temp;
            }
        }
    }
}
