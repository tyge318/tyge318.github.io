public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        int range = getShortestLength(strs);
        for(int i=0; i<range; i++) {
            if( sameCharAt(strs, i) )
                ans.append(strs[0].charAt(i) );
            else
                break;
        }
        return ans.toString();
    }
    public int getShortestLength(String[] strs) {
        int ans = strs[0].length();
        for(int i=1; i<strs.length; i++) {
            if( strs[i].length() < ans)
                ans = strs[i].length();
        }
        return ans;
    }
    public boolean sameCharAt(String[] strs, int i) {
        char cc = strs[0].charAt(i);
        for(int j=1; j<strs.length; j++) {
            char tcc = strs[j].charAt(i);
            if( cc != tcc)
                return false;
        }
        return true;
    }
}