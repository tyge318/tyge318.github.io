public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = (m == 0) ? 0: matrix[0].length;
        if( m*n == 0)
            return 0;
        
        int ans = Integer.MIN_VALUE;
        int M = Math.max(m, n), N = Math.min(m, n);
        for(int i=0; i<N; i++) {
            int[] sums = new int[M];
            for(int j=i; j<N; j++) {
                TreeSet<Integer> trace = new TreeSet<Integer>();
                int partialSum = 0;
                for(int l=0; l<M; l++) {
                    //if # of row > # of col => sum over row
                    //if # of col > # of row => sum over col
                    sums[l] += (m>n? matrix[l][j]: matrix[j][l]);
                    partialSum += sums[l];
                    if( partialSum <= k)
                        ans = Math.max(ans, partialSum);
                    
                    Integer closest = trace.ceiling(partialSum-k);
                    //closest = the smallest previous partialSum that >= current partialSum - k
                    //=> current partialSum - closest <= k
                    if( closest != null )
                        ans = Math.max(ans, partialSum-closest);
                    trace.add(partialSum);
                }
            }
        }
        return ans;
    }
}