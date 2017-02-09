public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> trace = new HashSet<Character>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if( trace.contains(c) )
                trace.remove(c);
            else
                trace.add(c);
        }
        return (trace.size() <= 1);
    }
}