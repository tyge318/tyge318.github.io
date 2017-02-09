import java.math.*;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<=rowIndex; i++)
            ans.add(comb(rowIndex, i) );
        return ans;
    }
    public int comb(int n, int k) {
        if(k > n/2)
            k = n-k;
        BigInteger numerator = BigInteger.valueOf(1);
        BigInteger denominator = BigInteger.valueOf(1);
        for(int i=n; i>n-k; i--)
            numerator = numerator.multiply(BigInteger.valueOf(i));
        for(int i=k; i>0; i--)
            denominator = denominator.multiply(BigInteger.valueOf(i));
        BigInteger temp = numerator.divide(denominator);
        return temp.intValue();
    }
}