public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if( dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int m = dungeon.length, n = (m == 0) ? 0 : dungeon[0].length;
        
        int opt[] = new int[n];
        
        //start from right most coloumn, right to left, down to top
        opt[n-1] = (dungeon[m-1][n-1] >= 0) ? 1 : -dungeon[m-1][n-1]+1;
        for(int i=n-2; i>=0; i--)
            opt[i] = (dungeon[m-1][i] >= opt[i+1]) ? 1 : opt[i+1]-dungeon[m-1][i];
        
        for(int i=m-2; i>=0; i--) {
            opt[n-1] = dungeon[i][n-1] >= opt[n-1] ? 1 : opt[n-1]-dungeon[i][n-1]; //right most column
            for(int j=n-2; j>=0; j--) {
                int temp = Math.min(opt[j], opt[j+1]); //opt[j]: from down, opt[j+1]: from right
                opt[j] = (dungeon[i][j] >= temp) ? 1 :temp-dungeon[i][j];
                
            }
        }
        return opt[0];
    }
}