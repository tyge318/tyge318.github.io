public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if( count.containsKey(c) )
                count.put(c, count.get(c)+1);
            else
                count.put(c, 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(count.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return -(o1.getValue().compareTo(o2.getValue()));
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> ent: list) {
            int n = ent.getValue();
            char c = ent.getKey();
            for(int i=0; i<n; i++)
                sb.append(c);
        }
        return sb.toString();
    }
}