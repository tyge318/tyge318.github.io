class TrieNode {
    // Initialize your data structure here.
    TrieNode[] nexts;
    boolean isLeaf;
    public TrieNode() {
        this.nexts = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++) {
            char cc = word.charAt(i);
            int index = cc - 'a';
            if( current.nexts[index] == null)
                current.nexts[index] = new TrieNode();
            current = current.nexts[index];
        }
        current.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return (node != null && node.isLeaf);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return (node != null);
    }
    
    public TrieNode findNode(String s) {
        TrieNode current = root;
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            int index = cc - 'a';
            current = ( current.nexts[index] == null) ? null: current.nexts[index];
            if( current == null )
                break;
        }
        return ((current == null || current == root) ? null: current);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");