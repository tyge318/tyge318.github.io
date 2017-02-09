public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        find(s, ans, new ArrayList<String>(), 0);
        return ans;
    }
    public void find(String s, List<List<String>> ans, List<String> last, int begin) {
        if(begin == s.length() ) {
            ans.add( new ArrayList<String>(last) );
            return;
        }
        for(int i=begin; i<s.length(); i++) {
            if( isPalindrome(s, begin, i) ) {
                last.add( s.substring(begin, i+1) );
                find(s, ans, last, i+1);
                //System.out.println(last.toString() );
                last.remove(last.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int begin , int end) {
        while( begin < end ) {
            if( s.charAt(begin) != s.charAt(end) )
                return false;
            begin++;
            end--;
        }
        return true;
    }
}