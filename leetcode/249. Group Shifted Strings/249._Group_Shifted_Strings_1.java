public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s: strings) {
            String key = getKey(s);
            List<String> value;
            if( map.containsKey(key) )
                value = map.get(key);
            else
                value = new ArrayList<String>();
            value.add(s);
            map.put(key, value);
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        for(String key: map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
    public String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<s.length(); i++) {
            char current = s.charAt(i);
            char previous = s.charAt(i-1);
            int diff = (int)current - (int)previous;
            if( diff < 0)
                diff += 26;
            sb.append(diff);
            if( i != s.length()-1 )
                sb.append(',');
        }
        return sb.toString();
    }
}