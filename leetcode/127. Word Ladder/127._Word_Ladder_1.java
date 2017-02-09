public class Solution {
    Map<String, List<String>> map;
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(beginWord);
        wordList.add(endWord);
        map = new HashMap<String, List<String>>();
        Set<String> currentLayer = new HashSet<String>();
        currentLayer.add(beginWord);
        Set<String> nextLayer = new HashSet<String>();
        
        int ans = 1;
        boolean foundEnd = false;
        while( true ) {
            Iterator<String> itr = currentLayer.iterator();
            while( itr.hasNext() ) {    //remove all words at the same layer
                String current = itr.next();
                wordList.remove(current);
            }
            itr = currentLayer.iterator();
            while( itr.hasNext() ) {    //find next layer words
                String current = itr.next();
                findNextLayerWords(current, wordList, nextLayer);
            }
            if( nextLayer.isEmpty() )
                break;
            if( nextLayer.contains(endWord) ) {
                foundEnd = true;
                ans++;
                break;
            }
            currentLayer.clear();
            currentLayer.addAll(nextLayer);
            nextLayer.clear();
            ans++;
        }
        if( foundEnd )
            return ans;
        else
            return 0;
    }
    public void findNextLayerWords(String current, Set<String> dict, Set<String> nextLayer) {
        StringBuilder s;
        for(int i=0; i<current.length(); i++) {
            s = new StringBuilder(current);
            for(char j='a'; j<='z'; j++) {
                s.setCharAt(i, j);
                String temp = s.toString();
                if( dict.contains(temp) ) {
                    nextLayer.add(temp);
                    List<String> currentList;
                    if( map.containsKey(temp) )
                        currentList = map.get(temp);
                    else
                        currentList = new ArrayList<String>();
                    currentList.add(current);
                    map.put(temp, currentList);
                }
            }
        }
    }
}