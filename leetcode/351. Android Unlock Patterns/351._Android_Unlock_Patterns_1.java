public class Solution {
    int[][] skip;
    boolean[] visited;
    public int numberOfPatterns(int m, int n) {
        visited = new boolean[10];
        skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[9][3] = skip[3][9] = 6;
        skip[9][7] = skip[7][9] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        
        int ans = 0;
        for(int i=m; i<=n; i++) {
            ans += count(1, i-1)*4; //1 = 3 = 7 = 9
            ans += count(2, i-1)*4; //2 = 4 = 6 = 8
            ans += count(5, i-1);
        }
        return ans;
    }
    public int count(int id, int len) {
        if( len < 0)    return 0;
        if( len == 0)   return 1;
        visited[id] = true;
        int ans = 0;
        //check every next position from id
        for(int i=1; i<=9; i++) {
            //skip if next position is visited.
            //or if it needs to pass an intermediate position and that intermediate position is not visited yet. 
            if(visited[i] || (skip[i][id] != 0 && !visited[skip[i][id]]) )
                continue;
            ans += count(i, len-1);
        }
        visited[id] = false;
        return ans;
    }
}