public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0; i<strs.length; i++) {
            String id = anagramID(strs[i]);
            if( map.containsKey(id) )
                map.get(id).add(strs[i]);
            else
                map.put(id, new ArrayList<String>(Arrays.asList(strs[i])) );
        }
        for(String key: map.keySet() ) {
            ans.add(map.get(key) );
        }
        return ans;
    }
    public String anagramID(String s) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            count[(int)(cc-'a')]++;
        }
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<count.length; i++) {
            temp.append(count[i]);
            if( i != count.length-1)
                temp.append("|");
        }
        return temp.toString();
    }
}