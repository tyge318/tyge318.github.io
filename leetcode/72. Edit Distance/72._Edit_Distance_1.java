public class Solution {
    public int minDistance(String word1, String word2) {
        if( word1.length() > word2.length() ) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        int m = word1.length()+1, n = word2.length()+1;
        int[][] opt = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( i == 0 && j == 0)
                    opt[i][j] = 0;
                else if (i == 0)
                    opt[i][j] = opt[i][j-1] + 1; //insertion
                else if (j == 0)
                    opt[i][j] = opt[i-1][j] + 1; //deletion
                else {
                    if( word1.charAt(i-1) == word2.charAt(j-1) )
                        opt[i][j] = opt[i-1][j-1];
                    else {
                        opt[i][j] = 1 + Math.min(Math.min(opt[i-1][j], opt[i][j-1]), opt[i-1][j-1]);
                    }
                }
                    
            }
        }
        return opt[m-1][n-1];
    }
}