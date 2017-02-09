public class Solution {
    public int strongPasswordChecker(String s) {
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        if( s.isEmpty() )
            return 6;
        int repeatCount = 1;
        char lastChar = '#';
        int replaceCount = 0;
        boolean flag = false; //take care of the case aa'a'aa
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            hasLower |= Character.isLowerCase(cc);
            hasUpper |= Character.isUpperCase(cc);
            hasDigit |= Character.isDigit(cc);
            if( lastChar == '#' && repeatCount == 0) {
                repeatCount++;
                lastChar = cc;
                continue;
            }
            if( cc == lastChar) {
                repeatCount++;
                if(repeatCount == 3) {
                    if( i+2 < s.length() && s.charAt(i+1) == cc && s.charAt(i+2) == cc) {
                        if( i+3 == s.length() || s.charAt(i+3) != cc) {
                            flag = true;
                            //System.out.println("@@@");
                        }
                    }
                    replaceCount++;
                    lastChar = '#';
                    repeatCount = 0;
                }
            }
            else {
                repeatCount = 1;
                lastChar = cc;
            }
        }
        int ans = 0;
        if( !hasLower ) {
            if( replaceCount != 0 ) //replaceCount includes 1 cost of replace a lower letter
                replaceCount--;
            ans++;
        }
        if( !hasUpper ) {
            if( replaceCount != 0) //replaceCount includes 1 cost of replace an upper letter
                replaceCount--;
            ans++;
        }
        if( !hasDigit ) {
            if( replaceCount != 0) //replaceCount includes 1 cost of replace a digit
                replaceCount--;
            ans++;
        }
        if( s.length() < 6) {
            int insertion = 6 - s.length();
            ans += Math.max(replaceCount, (insertion - ans));
        }
        //deletion might include replace cost
        else if( s.length() > 20) {
            int deletion = s.length() - 20;
            if( !flag )
                ans += Math.max(replaceCount, deletion);
            else {
                if( replaceCount > 0)
                    ans += (1 + deletion);
                else
                    ans += deletion;
            }
        }
        else {
            ans += replaceCount;
        }
        return ans;
            
    }
}