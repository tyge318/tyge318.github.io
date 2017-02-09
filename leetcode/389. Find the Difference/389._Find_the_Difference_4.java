public class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        s += t;
        for(int i=0; i<s.length(); i++)
            ans ^= s.charAt(i);
        return (char)ans;
    }
}