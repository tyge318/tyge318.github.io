public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        findPalindrome(s, ans, new ArrayList<String>(), 0);
        return ans;
    }
    //find Palindrome from substing s[i:]
    //List<String> last records last valid partiton which has not yet reached the end of string.
    public void findPalindrome(String s, List<List<String>> ans, List<String> last, int i) {
        if( i == s.length() ) { //reach the end
            ans.add( new ArrayList<String>(last) );
            return;
        }
        for(int j=i; j<s.length(); j++) {
            if( isPalindrome(s, i, j) ) {
                last.add(s.substring(i, j+1) );
                findPalindrome(s, ans, last, j+1);
                //need to remove last valid palidrome which begins at i.
                last.remove(last.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int begin, int end) {
        while( begin < end ) {
            if( s.charAt(begin) != s.charAt(end) )
                return false;
            begin++;
            end--;
        }
        return true;
    }
}