public class Solution {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        for(int i=1; i<factorials.length; i++)
            factorials[i] = i*factorials[i-1];
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for(int i=1; i<=n; i++)
            digits.add(i);
        StringBuilder temp = new StringBuilder();
        while( n > 0 ) {
            int pos = (k-1) / factorials[n-1];
            k -= (pos*factorials[n-1]);
            temp.append(digits.remove(pos));
            n--;
        }
        return temp.toString();
    }
}