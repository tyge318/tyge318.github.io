public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] trace = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            int index = cc - 'a';
            trace[index]++;
        }
        
        Stack<Character> st = new Stack<Character>();
        HashSet<Character> result = new HashSet<Character>();
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            int index = cc - 'a';
            trace[index]--;
            //result is just a hashset to enable O(1) time in checking letter existance.
            if( result.contains(cc) )
                continue;
            //st.peek() > cc => to ensure lexicographic order
            //trace[st.peek()-'a'] > 0 => to ensure each letter would be included.
            //if this is the last time this letter shows, then we should include it even when it violates the lexicographic order
            while( !st.isEmpty() && st.peek() > cc && trace[st.peek()-'a'] > 0) {
                result.remove(st.pop());
            }
            result.add(cc);
            st.push(cc);
        }
        StringBuilder temp = new StringBuilder();
        while( !st.isEmpty() )
            temp.insert(0, st.pop());
        return temp.toString();
    }
}