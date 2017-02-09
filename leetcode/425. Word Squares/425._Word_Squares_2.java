public class Solution {
    class TrieNode {
        TrieNode[] nexts;
        List<String> words;
        boolean isLeaf;
        public TrieNode() {
            nexts = new TrieNode[26];
            words = new ArrayList<String>();
        }
    }
    class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            for(String s: words) {
                insert(s);
            }
        }
        public void insert(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if( current.nexts[index] == null)
                    current.nexts[index] = new TrieNode();
                current.words.add(word);
                current = current.nexts[index];
            }
            current.isLeaf = true;
        }
        public List<String> getPrefixWords(String prefix) {
            TrieNode current = root;
            for(int i=0; i<prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if( current.nexts[index] == null )
                    return null;
                current = current.nexts[index];
            }
            return current.words;
        }
    }
    Trie root;
    int n;
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if( words.length == 0 )
            return ans;
        root = new Trie(words);
        n = words[0].length();
        List<String> temp = new ArrayList<String>();
        for(String s: words) {
            temp.add(s);
            dfs(ans, temp);
            temp.remove(temp.size()-1);
        }
        return ans;
    }
    public void dfs(List<List<String>> ans, List<String> temp) {
        if( temp.size() == n) {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        int pos = temp.size();
        StringBuilder sb = new StringBuilder();
        for(String s: temp) 
            sb.append(s.charAt(pos));
        List<String> candidates = root.getPrefixWords(sb.toString());
        if( candidates == null)
            return;
        for(String s: candidates) {
            temp.add(s);
            dfs(ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}