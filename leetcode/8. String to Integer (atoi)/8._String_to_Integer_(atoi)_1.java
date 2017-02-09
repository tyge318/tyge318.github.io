import java.math.*;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        //long ans = 0;
        BigInteger ans = BigInteger.ZERO;
        int strLength = str.length(), effectiveLength = 0;
        for(int i=0; i<str.length(); i++) {
            char cc = str.charAt(i);
            if(cc == ' ') {
                strLength = i;
                break;
            }
            //ans *= 10;
            ans = ans.multiply(BigInteger.TEN);
            int digit = (cc - '0');
            if(digit >= 0 && digit <= 9) {
                //ans += digit;
                ans = ans.add(new BigInteger(str.substring(i, i+1)) );
                effectiveLength++;
            }
            else if(digit < 0) {
                //ans += 0;
                ans = ans.add(BigInteger.ZERO);
            }
            else {
                strLength = i;
                //ans /= 10;
                ans = ans.divide(BigInteger.TEN);
                break;
            }
        }
        System.out.println("ans = " + ans.toString());
        
        if(strLength > 0 && str.charAt(0) == '-')
            ans = ans.multiply(new BigInteger("-1") );
        int output = 0;
        //if( ans >= Integer.MAX_VALUE)
        if( ans.compareTo(new BigInteger("2147483647")) == 1 )
            output = Integer.MAX_VALUE;
        //else if (ans <= Integer.MIN_VALUE)
        else if( ans.compareTo(new BigInteger("-2147483648")) == -1 )
            output = Integer.MIN_VALUE;
        else
            output = ans.intValue();
        //System.out.println("ans = " + output);
        if(strLength - effectiveLength >= 2)
            return 0;
        return output;
    }
}