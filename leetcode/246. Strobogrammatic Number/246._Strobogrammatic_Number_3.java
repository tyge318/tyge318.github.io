public class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length(); i++) {
            char cc = num.charAt(i);
            sb.append(upsideDown(cc));
        }
        return num.equals(sb.reverse().toString());
    }
    public char upsideDown(char c) {
        if( c == '0' || c == '1' || c == '8')
            return c;
        else if( c == '6')
            return '9';
        else if( c == '9')
            return '6';
        else
            return '#';
    }
}