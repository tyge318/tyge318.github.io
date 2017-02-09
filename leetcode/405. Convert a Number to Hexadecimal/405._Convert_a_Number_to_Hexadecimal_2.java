public class Solution {
    public String toHex(int num) {
        if( num == 0)
            return "0";
        StringBuilder temp = new StringBuilder();
        while( num != 0) {
            int hexVal = num & 0xf;
            num >>>= 4;
            temp.append(getHexChar(hexVal));
        }
        return temp.reverse().toString();
    }
    public char getHexChar(int i) {
        char c = (char)i;
        if( i >= 0 && i <= 9)
            return (char)(c+'0');
        else if( i >= 10 && i <= 15)
            return (char)(c-10+'a');
        else {
            System.out.println("i = " + i);
            return ' ';
        }
    }
}