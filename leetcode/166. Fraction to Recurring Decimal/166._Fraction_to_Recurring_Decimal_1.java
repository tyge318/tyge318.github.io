public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder temp = new StringBuilder();
        boolean neg = false;
        if( (numerator < 0) ^ (denominator < 0) ) {
            temp.append('-');
            neg = true;
        }
        long n = Math.abs((long)numerator), d = Math.abs((long)denominator);
        temp.append( n/d );
        long r = (n % d) * 10;
        if( r == 0 ) {
            if( n/d == 0 )  return "0";
            return temp.toString();
        }

        temp.append(".");
        Map<Long, Integer> trace = new HashMap<Long, Integer>();
        int pos = temp.length();
        while( r != 0 ) {
            if( trace.containsKey(r) ) {
                int p = trace.get(r);
                temp.insert(p, '(');
                temp.append(')');
                return temp.toString();
            }
            trace.put(r, pos);
            temp.append( r/d );
            r = (r % d) * 10;
            pos++;
        }
        return temp.toString();
    }
}