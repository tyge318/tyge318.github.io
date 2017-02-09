public class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];
        for(int i=0; i<secret.length(); i++) {
            char c = secret.charAt(i);
            if( guess.charAt(i) == c)   A++;
            secretCounts[c - '0']++;
            guessCounts[guess.charAt(i)-'0']++;
        }
        for(int i=0; i<10; i++) {
            B += Math.min(secretCounts[i], guessCounts[i]);
        }
        B -= A;
        String ans = String.format("%sA%sB", A, B);
        return ans;
    }
}