public class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while( k > 0) {
            int d = findDistance(n, current, current+1);
            if( d <= k) {   //the answer will be on the siblings.
                current++;
                k -= d;
            }
            else {  //the answer will be on the children.
                current *= 10;
                k--;
            }
        }
        return current;
    }
    public int findDistance(int n, long from, long to) {
        int ans = 0;
        while( from <= n) {
            ans += Math.min(n+1, to) - from;
            from *= 10;
            to *= 10;
        }
        return ans;
    }
}