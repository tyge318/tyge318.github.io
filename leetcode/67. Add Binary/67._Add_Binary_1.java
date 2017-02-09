public class Solution {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        StringBuilder tempA = new StringBuilder(a);
        StringBuilder tempB = new StringBuilder(b);
        while( length - tempA.length() > 0)
            tempA.insert(0, '0');
        while( length - tempB.length() > 0)
            tempB.insert(0, '0');
        tempA = tempA.reverse();
        tempB = tempB.reverse();
        
        StringBuilder sum = new StringBuilder();
        boolean carry = false;
        for(int i=0; i<tempA.length(); i++) {
            boolean tempSum = carry ^ (tempA.charAt(i) == '1') ^ (tempB.charAt(i) == '1');
            carry = (tempA.charAt(i) == '1') && (tempB.charAt(i) == '1') ||
                    (tempA.charAt(i) == '1') && carry || (tempB.charAt(i) == '1') && carry;
            sum.append( (tempSum ? '1': '0') );
        }
        if(carry)
            sum.append('1');
        return sum.reverse().toString();
            
    }
}