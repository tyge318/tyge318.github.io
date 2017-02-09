public class Solution {
    int n;
    public int kthSmallest(int[][] matrix, int k) {
        n = matrix.length;
        int begin = matrix[0][0], end = matrix[n-1][n-1];
        while( begin < end) {
            int mid = begin + (end-begin)/2;
            int count = countLessThan(matrix, mid);
            if( count < k)
                begin = mid+1;
            else
                end = mid;
        }
        return end;
    }
    public int countLessThan(int[][] matrix, int target) {
        int i = n-1, j = 0;
        int count = 0;
        while( i>=0 && j<n ) {
            if( matrix[i][j] <= target) {
                count += (i+1);
                j++;
            }
            else {
                i--;
            }
        }
        return count;
    }
}