public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> trace = new HashSet<Character>();
        
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( trace.contains(cc) ) {
                trace.remove(cc);
                count += 2;
            }
            else
                trace.add(cc);
        }
        return (trace.isEmpty()) ? count: count+1;
    }
}