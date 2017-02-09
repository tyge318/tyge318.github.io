/*
int numSquares(int n) {
    while (n % 4 == 0)
        n /= 4;
    if (n % 8 == 7)
        return 4;
    for (int a=0; a*a<=n; ++a) {
        int b = sqrt(n - a*a);
        if (a*a + b*b == n)
            return !!a + !!b;
    }
    return 3;
}
*/
public class Solution {
    public int numSquares(int n) {
        while ( n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for(int i=0; i*i <= n; ++i) {
            int j = (int)Math.sqrt(n - i*i);
            if(i*i+j*j == n) {
                int t_i = (i == 0) ? 0 : 1;
                int t_j = (j == 0) ? 0 : 1;
                return t_i+t_j;
            }
        }
        return 3;
    }
}