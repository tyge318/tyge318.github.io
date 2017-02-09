public class Solution {
    Map<String, List<String>> map;
    List<List<String>> ans;
    List<String> path;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(beginWord);
        wordList.add(endWord);
        
        map = new HashMap<String, List<String>>();
        ans = new ArrayList<List<String>>();
        path = new ArrayList<String>();
        
        Set<String> currentLayer = new HashSet<String>();
        currentLayer.add(beginWord);
        Set<String> nextLayer = new HashSet<String>();
        path.add(endWord);
        
        while( true) {
            Iterator<String> itr = currentLayer.iterator();
            while( itr.hasNext() ) {
                String current = itr.next();
                wordList.remove(current);
            }
            itr = currentLayer.iterator();
            while( itr.hasNext() ) {
                String current = itr.next();
                findNextLayerWords(current, wordList, nextLayer);
            }
            if( nextLayer.isEmpty() )
                break;
                //return ans;
            if( nextLayer.contains(endWord) ) {
                traceBack(beginWord, endWord);
                break;
                //return ans;
            }
            currentLayer.clear();
            currentLayer.addAll(nextLayer);
            nextLayer.clear();
        }
        return ans;
        
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
    public void traceBack(String start, String end) {
        if( end.equals(start) ) {
            Collections.reverse(path);
            ans.add( new ArrayList<String>(path) );
            Collections.reverse(path);
        }   
        else {
            for(int i=0; i<map.get(end).size(); i++) {
                path.add(map.get(end).get(i) );
                traceBack(start, map.get(end).get(i) );
                path.remove(path.size()-1);
            }
        }
    }
    public class Node {
        String word;
        int level;
        Set<List<String>> paths;
        public Node(String word, int level, Node prev) {
            this.word = word;
            this.level = level;
            this.paths = new HashSet<List<String>>();
            if( prev == null ) {
                this.paths.add( new ArrayList<String>(Arrays.asList(word)) ); //contains only current
            }
            else {
                Set<List<String>> pathsToPrev = prev.paths;
                for(List<String> l: pathsToPrev) {
                    List<String> temp = new ArrayList<String>(l);
                    temp.add(word);
                    this.level = temp.size();
                    this.paths.add(temp);
                }
            }
        }
        public void updateMinPath(Node prev) {
            if( prev.level+1 > this.level)  return;
            if( prev.level+1 < this.level) this.paths.clear();
            
            Set<List<String>> pathsToPrev = prev.paths;
            for(List<String> l: pathsToPrev) {
                List<String> temp = new ArrayList<String>(l);
                temp.add(this.word);
                this.level = temp.size();
                this.paths.add(temp);
            }
        }
        public void updateWithNode(Node node) {
            if( node.level > this.level)    return;
            if( node.level < this.level)    this.paths.clear();
            
            for(List<String> l: node.paths) {
                List<String> temp = new ArrayList<String>(l);
                this.level = temp.size();
                this.paths.add(temp);
            }
        }
    }
    public List<List<String>> findLaddersSub(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(beginWord);
        wordList.add(endWord);
        HashMap<String, Set<String>> adj = buildG(wordList);
        
        List<List<String>> ans = new ArrayList<List<String>>();
        
        int minLen = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<Node>();
        HashMap<String, Node> visited = new HashMap<String, Node>();
        q.add(new Node(beginWord, 1, null) );
        while( !q.isEmpty() ) {
            Node current = q.poll();
            for(String next: adj.get(current.word)) {
                enqueueNext(q, visited, current, next);
            }
            if( visited.containsKey(current.word) ) { //merge to existing
            	visited.get(current.word).updateWithNode(current);
            }
            else
            	visited.put(current.word, current);
        }
        if( visited.containsKey(endWord) )
            ans.addAll(visited.get(endWord).paths);
        return ans;
    }
    public void enqueueNext(Queue<Node> q, HashMap<String, Node> visited, Node current, String next) {
        Node nextNode = (visited.containsKey(next)) ? visited.get(next): (new Node(next, current.level+1, current));
        if( nextNode.level < current.level+1 ) return;
        nextNode.updateMinPath(current);
        if( !visited.containsKey(next) )
            q.add(nextNode);
    }
    public HashMap<String, Set<String>> buildG(Set<String> wordList) {
        HashMap<String, Set<String>> ans = new HashMap<String, Set<String>>();
        String[] words = wordList.toArray(new String[wordList.size()]);
        int len = words[0].length();
        for(int i=0; i<len; i++) {
            HashMap<String, Set<String>> group = groupWords(words, i);
            categorize(group, ans);
        }
        return ans;
    }
    public HashMap<String, Set<String>> groupWords(String[] words, int index) {
        String[] temp = new String[words.length];
        HashMap<String, Set<String>> group = new HashMap<String, Set<String>>();
        for(int j=0; j<words.length; j++) {
            temp[j] = words[j].substring(0, index) + words[j].substring(index+1);
            if( !group.containsKey(temp[j]) ) {
                group.put(temp[j], new HashSet<String>(Arrays.asList(words[j])) );
            }
            else{
                Set<String> myGroup = group.get(temp[j]);
                myGroup.add(words[j]);
            }
        }
        return group;
    }
    public void categorize(HashMap<String, Set<String>> group, HashMap<String, Set<String>> ans) {
        for(String key: group.keySet() ) {
        	Set<String> currentSet = group.get(key);
        	for(String w: currentSet ) {
        		HashSet<String> value = new HashSet(currentSet);
        		value.remove(w);
        		if( ans.containsKey(w) )
        			ans.get(w).addAll(value);
        		else
        			ans.put(w, value);
        	}
        }
    }
    
}