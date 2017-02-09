public class Solution {
    public int minCut(String s) {
        boolean[][] opt = new boolean[s.length()][s.length()];
        int min[] = new int[s.length()];
        
        for(int right = 0; right < s.length(); right++) {
            min[right] = right;
            for(int left = 0; left <= right; left++) {
                if( s.charAt(left) == s.charAt(right)) {
                    if( right-left <= 1 || opt[left+1][right-1]) {
                        opt[left][right] = true;
                        if( left == 0)  //s[0:right] is a palindrome
                            min[right] = 0;
                        else    //choose between current and # of partition in s[0:left-1] + 1 (s[left:right])
                            min[right] = Math.min(min[right], min[left-1]+1);
                    }
                }
            }
        }
        return min[s.length()-1];
    }
}