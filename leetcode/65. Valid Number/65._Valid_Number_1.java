public class Solution {
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        if(s.isEmpty())
            return false;
        boolean signValid = false;
        boolean expValid = false;
        boolean dotValid = false;
        boolean charValid = false;
        
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == '+' || cc == '-') {
                if( i == 0 || s.charAt(i-1) == 'e' && (i<s.length()-1 && s.charAt(i+1) >='0' && s.charAt(i+1) <= '9') )
                    continue;
                else
                    return false;
            }
            else if( cc == 'e') {   //must appear after charValid is set
                if( !charValid || expValid || i == s.length()-1)
                    return false;
                expValid = true;
            }
            else if( cc == '.') {   //must appear after charValid is set
                if( expValid || dotValid || (!charValid && i == s.length()-1) )
                    return false;
                dotValid = true;
            }
            else if( cc >= '0' && cc <= '9')
                charValid = true;
            else
                return false;
        }
        return true;
    }
}