public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        if( s.length() < 10)
            return ans;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        
        int mask = (1 << 20) - 1, key = 0;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i=0; i<s.length(); i++) {
            key = (key << 2) + map.get(s.charAt(i) );
            if( i < 9 ) continue;
            key = key & mask;
            if( !count.containsKey(key) )
                count.put(key, 1);
            else {
                if( count.get(key) == 1 ) 
                    ans.add(s.substring(i-9, i+1) );
                count.put(key, count.get(key)+1);
            }
        }
        return ans;
    }
}