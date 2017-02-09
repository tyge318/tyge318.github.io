public class Solution {
    public int longestSubstring(String s, int k) {
        if( s.length() < k)
            return 0;
        int[] count = countChar(s);
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            int[] temp = Arrays.copyOf(count, 26);
            for(int j=0; j<i; j++) {
                int index = s.charAt(j) - 'a';
                temp[index]--;
            }
            for(int j=s.length()-1; j>=i; j--) {
                if( j-i+1 < k)
                    continue;
                if( valid(temp, k) ) {
                    //System.out.println("@Valid: (i, j) = (" + i + ", " + j +"); temp = " + Arrays.toString(temp));
                    ans = Math.max(ans, (j-i+1) );
                    break;
                }
                int index = s.charAt(j) - 'a';
                temp[index]--;
            }
            if( ans == s.length())  break;
        }
        return ans;
    }
    public boolean valid(int[] count, int k) {
        int counter = 0;
        for(int i=0; i<26; i++) {
            if( count[i] == 0) {
                counter++;
                continue;
            }
            if( count[i] < k)
                return false;
        }
        return (counter == 26) ? false: true;
    }
    public int[] countChar(String s) {
        int[] opt = new int[26];
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i)-'a';
            opt[index]++;
        }
        return opt;
    }
}