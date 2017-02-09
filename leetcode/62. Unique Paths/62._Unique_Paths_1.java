public class Solution {
    public int uniquePaths(int m, int n) {
        return combination((m+n-2), Math.min(m-1, n-1));
    }
    public int combination(int n, int k) {
        long numerator = 1, denominator = 1;
        int counter = 1;
        while( counter <= k) {
            numerator *= n;
            n--;
            denominator *= counter;
            counter++;
        }
        return (int)(numerator/denominator);
    }
}