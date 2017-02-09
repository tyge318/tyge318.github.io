public class ValidWordAbbr {
    Map<String, List<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, List<String>>();
        Set<String> wordSet = new HashSet<String>();
        for(String s: dictionary) {
            wordSet.add(s);
        }
        for(String s: wordSet) {
            String key = encode(s);
            if( map.containsKey(key) )
                map.get(key).add(s);
            else 
                map.put(key, new ArrayList<String>(Arrays.asList(s)) );
        }
    }

    public boolean isUnique(String word) {
        String key = encode(word);
        if( !map.containsKey(key) )
            return true;
        else {
            if( map.get(key).size() == 1 && map.get(key).get(0).equals(word) )
                return true;
            else
                return false;
        }
    }
    
    public String encode(String word) {
        StringBuilder sb = new StringBuilder();
        if( word.length() <= 2)
            return word;
        sb.append(word.charAt(0));
        sb.append(word.substring(1, word.length()-1).length());
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");