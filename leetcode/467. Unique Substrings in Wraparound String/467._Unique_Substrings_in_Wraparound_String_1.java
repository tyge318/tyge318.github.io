public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] counts = new int[26];
        int temp = 0;
        for(int i=0; i<p.length(); i++) {
            if( i > 0 && (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i) - p.charAt(i-1) == -25 ) )
                temp++;
            else
                temp = 1;
            counts[p.charAt(i)-'a'] = Math.max(counts[p.charAt(i)-'a'], temp);    
        }
        int ans = 0;
        for(int i: counts)
            ans += i;
        return ans;
    }
}