public class Solution {
    public String reverseWords(String s) {
        String tokens[] = s.split("\\s+");
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<tokens.length; i++) {
            temp.insert(0, " "+tokens[i]);
        }
        return temp.toString().trim();
    }
}