public class Solution {
    public int lengthOfLastWord(String s) {
        String[] tokens = s.split(" ");
        return (tokens.length == 0 ? 0 : (tokens[tokens.length-1].length() ) );
    }
}