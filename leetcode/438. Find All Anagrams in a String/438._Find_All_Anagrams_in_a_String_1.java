public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        int len = p.length();
        int[] p_counts = new int[26];
        for(int i=0; i<p.length(); i++)
            p_counts[p.charAt(i)-'a']++;
        for(int i=0; i<=s.length()-len; i++) {
            String ss = s.substring(i, i+len);
            int[] temp = new int[26];
            for(int j=0; j<ss.length(); j++) 
                temp[ss.charAt(j)-'a']++;
            if( Arrays.toString(temp).equals(Arrays.toString(p_counts)) )
                ans.add(i);
        }
        return ans;
    }
}