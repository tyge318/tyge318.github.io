public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if( digits.length() > 0)
            ans = getComb(map, digits, 0, ans);
        return ans;
    }
    public List<String> getComb(HashMap<Integer, String> map, String digits, int pos, List<String> last) {
        int key = digits.charAt(pos) - '0';
        String candidates = ( key < 2 || key > 9) ? "" : map.get(key);
        List<String> ans = new ArrayList<String>();
        if( last.size() == 0) {
            StringBuilder temp = new StringBuilder();
            appendToAns(ans, candidates, temp);
        }
        else {
            for(int i=0; i<last.size(); i++) {
                StringBuilder temp = new StringBuilder(last.get(i) );
                appendToAns(ans, candidates, temp);
            }
        }
        if( pos == digits.length()-1) {
            return ans;
        }
        else {
            return getComb(map, digits, pos+1, ans);
        }
    }
    public void appendToAns(List<String> ans, String candidates, StringBuilder input) {
        for(int j=0; j<candidates.length(); j++) {
            char cc = candidates.charAt(j);
            input.append(cc);
            ans.add(input.toString());
            input.deleteCharAt(input.length()-1);
        }
    }
}