public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] trace = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            int index = cc - 'a';
            trace[index]++;
        }
        
        StringBuilder st = new StringBuilder();
        HashSet<Character> result = new HashSet<Character>();
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            int index = cc - 'a';
            trace[index]--;
            //result is just a hashset to enable O(1) time in checking letter existance.
            if( result.contains(cc) )
                continue;
            //st.charAt(st.length()-1) > cc => to ensure lexicographic order
            //trace[st.charAt(st.length()-1)-'a'] > 0 => to ensure each letter would be included.
            //if this is the last time this letter shows, then we should include it even when it violates the lexicographic order
            while( st.length() > 0 && st.charAt(st.length()-1) > cc && trace[st.charAt(st.length()-1)-'a'] > 0) {
                char last = st.charAt(st.length()-1);
                st.deleteCharAt(st.length()-1);
                result.remove(last);
            }
            result.add(cc);
            st.append(cc);
        }
        return st.toString();
    }
}