public class Solution {
    public char findTheDifference(String s, String t) {
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            StringBuilder temp = new StringBuilder(t);
            temp.deleteCharAt(t.indexOf(cc));
            t = temp.toString();
        }
        return t.charAt(0);
    }
}