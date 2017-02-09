public class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] counts = new int[26];
        int begin = 0, maxCount = 0, ans = 0;
        for(int end = 0; end < n; end++) {
            char cc = s.charAt(end);
            counts[cc-'A']++;
            maxCount = Math.max(maxCount, counts[cc-'A']);
            while( end - begin + 1 - maxCount > k ) {
                counts[s.charAt(begin)-'A']--;
                begin++;
            }
            ans = Math.max(ans, end - begin + 1);
        }
        return ans;
    }
}