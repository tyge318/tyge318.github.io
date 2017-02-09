public class Solution {
    Map<String, Integer> map;
    List<List<Integer>> ans;
    public List<List<Integer>> palindromePairs(String[] words) {
        map = new HashMap<String, Integer>();
        ans = new ArrayList<List<Integer>>();
        for(int i=0; i<words.length; i++)
            map.put(words[i], i);
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            if( map.containsKey("") && !word.isEmpty() && isPalindrome(word) ) {
                Integer theOtherIndex = map.get("");
                ans.add( new ArrayList<Integer>(Arrays.asList(new Integer(i), theOtherIndex) ) );
                ans.add( new ArrayList<Integer>(Arrays.asList(theOtherIndex, new Integer(i)) ) );
            }
            
            String reverseWord = (new StringBuilder(word)).reverse().toString();
            if( map.containsKey(reverseWord) ) {
                Integer reverseWordIndex = map.get(reverseWord);
                if( i != reverseWordIndex ) {
                    ans.add( new ArrayList<Integer>(Arrays.asList(new Integer(i), reverseWordIndex) ) );
                }
            }
            
            for(int k=1; k<word.length(); k++) {
                String left = word.substring(0, k);
                String right = word.substring(k);
                
                if( isPalindrome(right) ) {
                    String leftReverse = (new StringBuilder(left)).reverse().toString();
                    if( map.containsKey(leftReverse) && (map.get(leftReverse) != i) ) {
                        ans.add( new ArrayList<Integer>(Arrays.asList(new Integer(i), map.get(leftReverse) ) ) );
                    }
                }
                if( isPalindrome(left) ) {
                    String rightReverse = (new StringBuilder(right)).reverse().toString();
                    if( map.containsKey(rightReverse) && (map.get(rightReverse) != i) ) {
                        ans.add( new ArrayList<Integer>(Arrays.asList(map.get(rightReverse), new Integer(i) ) ) );
                    }
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> bruteForce(String[] words) {
        ans = new ArrayList<List<Integer>>();
        
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if( isPalindrome(words[i]+words[j]) )
                    ans.add( new ArrayList<Integer>(Arrays.asList(new Integer(i), new Integer(j))) );
                if( isPalindrome(words[j]+words[i]) )
                    ans.add( new ArrayList<Integer>(Arrays.asList(new Integer(j), new Integer(i))) );
            }
        }
        return ans;
    }
    
    public boolean isPalindrome(String s) {
        int begin = 0, end = s.length()-1;
        while( begin < end) {
            if( s.charAt(begin) != s.charAt(end) )
                return false;
            begin++;
            end--;
        }
        return true;
    }
}