public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> trace = new HashSet<Integer>();
        int temp = convert(n);
        while( !trace.contains(temp) ) {
            trace.add(temp);
            n = temp;
            temp = convert(n);
            if( temp == 1)
                return true;
        }
        return false;
    }
    public int convert(int n) {
        int ans = 0;
        while( n > 0 ) {
            ans += ((n % 10)*(n % 10));
            n /= 10;
        }
        return ans;
    }
}