public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int ans = 0, g_index = 0;
        for(int i=0; i<s.length; i++) {
            for(int j=g_index; j<g.length; j++) {
                if( s[i] >= g[j]) {
                    ans++;
                    g_index = j+1;
                    break;
                }
            }
        }
        return ans;
    }
}