public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = (m == 0)? 0 : matrix[0].length;
        if( m == 0)
            return 0;
        
        int[][] count = new int[m][n];
        
        int ans = 0;
        //first row
        for(int j=0; j<n; j++) {
            count[0][j] = matrix[0][j] - '0';
            ans = Math.max(ans, count[0][j]);
        }
        //first col
        for(int i=0; i<m; i++) {
            count[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, count[i][0]);   
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if( matrix[i][j] == '0')
                    count[i][j] = 0;
                else{   //matrix[i][j] == '1'
                    if( !(matrix[i-1][j-1] == '1' && matrix[i-1][j] == '1' && matrix[i][j-1] == '1') )
                        count[i][j] = 1;
                    else {
                        count[i][j] = Math.min(count[i-1][j-1], Math.min(count[i][j-1], count[i-1][j])) + 1;
                    }
                }
                ans = Math.max(ans, count[i][j]);
            }
        }
        return ans*ans;
    }
}