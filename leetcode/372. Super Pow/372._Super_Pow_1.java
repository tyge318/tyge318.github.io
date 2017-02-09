public class Solution {
    public int power(int x, int y) {    //calculate (x^y) % 1337
        int ans = 1;
        while( y > 0) {
            ans = (ans * x) % 1337;
            y--;
        }
        return ans;
    }
    public int superPow(int a, int[] b) {
        int ptr = b.length-1;
        a = a % 1337;
        long ans = 1;
        while( ptr >= 0 ) {
            ans = (ans * power(a, b[ptr]) ) % 1337;
            ptr--;
            // a^(b[ptr-1]*10+b[ptr]) % 1337
            a = power(a, 10);
        }
        return (int)ans;
    }
}