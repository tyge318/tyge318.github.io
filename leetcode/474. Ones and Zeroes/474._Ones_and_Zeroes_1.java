public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] opt = new int[m+1][n+1];
        
        for(String s: strs) {
            int[] pair = getPair(s);
            for(int i=m; i>=pair[0]; i--) {
                for(int j=n; j>=pair[1]; j--) {
                    opt[i][j] = Math.max(1+opt[i-pair[0]][j-pair[1]], opt[i][j]);
                }
            }
        }
        return opt[m][n];
    }
    public int[] getPair(String s) {
        int m = 0, n = 0;
        for(char c: s.toCharArray() ) {
            if( c == '0')   m++;
            else    n++;
        }
        return (new int[]{m, n});
    }
}