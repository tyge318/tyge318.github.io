public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        num1 = (new StringBuilder(num1)).reverse().toString();
        num2 = (new StringBuilder(num2)).reverse().toString();
        int carry = 0;
        for(int i=0; i<Math.max(num1.length(), num2.length()); i++) {
            char d1 = (i >= num1.length()) ? '0': num1.charAt(i);
            char d2 = (i >= num2.length()) ? '0': num2.charAt(i);
            int tempSum = (d1 - '0') + (d2 - '0') + carry;
            carry = tempSum / 10;
            sum.append( (tempSum % 10) );
        }
        if( carry != 0 )
            sum.append( carry );
        return sum.reverse().toString();
    }
}