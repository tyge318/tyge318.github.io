public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        return word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}"));
    }
}