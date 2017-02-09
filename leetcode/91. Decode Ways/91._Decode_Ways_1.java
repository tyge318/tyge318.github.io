public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if( n < 1 )
            return 0;
        int[] opt = new int[n+1];
        opt[0] = 1;
        for(int i=1; i<=n; i++) {
            if( s.charAt(i-1) > '0')
                opt[i] += opt[i-1];
            if (i > 1 && (new Integer(s.substring(i-2, i))) >= 10 && (new Integer(s.substring(i-2, i))) <= 26) {
                opt[i] += opt[i-2];
            }
        }
        System.out.println(Arrays.toString(opt));
        return opt[n];
    }
}