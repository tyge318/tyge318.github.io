public class Solution {
    public int minCost(int[][] costs) {
        if( costs == null || costs.length == 0 )
            return 0;
        int n = costs.length;
        int[][] opt = new int[n][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                if( i == 0 ) {
                    opt[0][j] = costs[0][j];
                    continue;
                }
                opt[i][j] = costs[i][j]+Math.min(opt[i-1][(j+1)%3], opt[i-1][(j+2)%3]);
            }
        }
        int ans = Math.min(opt[n-1][0], Math.min(opt[n-1][1], opt[n-1][2]) );
        return ans;
    }
}