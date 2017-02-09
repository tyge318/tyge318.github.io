public class Solution {
    public String convertToTitle(int n) {
        StringBuilder temp = new StringBuilder();
        while( n > 0) {
            n--;
            char cc = (char)('A' + (n % 26));
            temp.append(cc);
            n /= 26;
        }
        return temp.reverse().toString();
    }
}