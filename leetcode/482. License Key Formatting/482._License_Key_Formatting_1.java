public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S.replaceAll("-", "").toUpperCase());
        sb.reverse();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while( i < sb.length() ) {
            ans.append(sb.substring(i, Math.min(i+K, sb.length())) + "-");
            i += K;
        }
        if( ans.length() > 0 && ans.charAt(ans.length()-1) == '-')
            ans.deleteCharAt(ans.length()-1);
        return ans.reverse().toString();
    }
}