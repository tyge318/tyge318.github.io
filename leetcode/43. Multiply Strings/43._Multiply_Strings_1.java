public class Solution {
    public String multiply(String num1, String num2) {
        if( num1.isEmpty() || num2.isEmpty() )
            return "";
        String a = new StringBuilder(num1).reverse().toString();
        String b = new StringBuilder(num2).reverse().toString();
        StringBuilder c = new StringBuilder();
        for(int i=0; i<a.length()+b.length(); i++)
            c.append(' ');
        
        for(int i=0; i<b.length(); i++) {
            int valB = Character.digit(b.charAt(i), 10);
            int carry = 0;
            for(int j=0; j<a.length(); j++) {
               int valA = Character.digit(a.charAt(j), 10);
               int existing = (c.charAt(i+j) == ' ') ? 0 : Character.digit(c.charAt(i+j), 10);
               int product = valA * valB + carry + existing;
               carry = product / 10;
               c.setCharAt(i+j, Character.forDigit(product % 10, 10));
            }
            if( carry != 0)
                c.setCharAt(a.length()+i, Character.forDigit(carry, 10));
        }
        String ans = c.reverse().toString().trim();
        if( ans.matches("[0]+") )
            return "0";
        else
            return ans;
        
    }
}