public class ValidWordAbbr {
    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String s: dictionary) {
            String key = getAbbr(s);
            if( !map.containsKey(key) )
                map.put(key, new HashSet<>());
            map.get(key).add(s);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if( !map.containsKey(abbr) )    return true;
        else if( map.containsKey(abbr) && map.get(abbr).size() == 1 && map.get(abbr).contains(word) )
            return true;
        else
            return false;
    }
    
    public String getAbbr(String word) {
        if( word.length() <= 2)
            return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length()-2);
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");