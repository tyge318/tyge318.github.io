import java.math.*;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        boolean singleMid = (rowIndex % 2 == 0);
        for(int i=0; i<=rowIndex/2; i++) {
            ans.add(comb(rowIndex, i) );
            temp.add(0, comb(rowIndex, i) );
        }
        if(singleMid)  temp.remove(0);
        ans.addAll(temp);
        return ans;
    }
    public int comb(int n, int k) {
        if(k > n/2)
            k = n-k;
        /*
        BigInteger numerator = BigInteger.valueOf(1);
        BigInteger denominator = BigInteger.valueOf(1);
        for(int i=n; i>n-k; i--)
            numerator = numerator.multiply(BigInteger.valueOf(i));
        for(int i=k; i>0; i--)
            denominator = denominator.multiply(BigInteger.valueOf(i));
        BigInteger temp = numerator.divide(denominator);
        return temp.intValue(); */
        int counter = 0;
        long numerator = 1, denominator = 1;
        while( counter < k) {
            numerator *= (n-counter);
            counter++;
            denominator *= counter;
            if( numerator % denominator == 0) {
                numerator /= denominator;
                denominator = 1;
            }
        }
        return (int)(numerator/denominator);
    }
}