public class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        while( left < s.length() && !vowels.contains(s.charAt(left)) )
            left++;
        while( right >= 0 && !vowels.contains(s.charAt(right)) )
            right--;
        
        StringBuilder sb = new StringBuilder(s);
        while( left < right ) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            left++;
            sb.setCharAt(right, temp);
            right--;
            while( left < sb.length() && !vowels.contains(sb.charAt(left)) )
                left++;
            while( right >= 0 && !vowels.contains(sb.charAt(right)) )
                right--;
        }
        return sb.toString();
    }
}