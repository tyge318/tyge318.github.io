public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int ans = 0;
        int base = minutesToTest/minutesToDie+1;
        while( Math.pow(base, ans) < buckets )
            ans++;
        return ans;
    }
}