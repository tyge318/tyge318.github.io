public class WordDictionary {
    class TrieNode {
        // Initialize your data structure here.
        TrieNode[] nexts;
        boolean isLeaf;
        public TrieNode() {
            this.nexts = new TrieNode[26];
        }
        public boolean hasNext(String s, int index) {
            if( index == s.length() ) {
                return (this.isLeaf);
            }
            char cc = s.charAt(index);
            if( cc == '.') {
                for(int i=0; i<26; i++) {
                    if(nexts[i] == null) continue;
                    if(nexts[i].hasNext(s, index+1) )
                        return true;
                }
                return false;
            }
            else {
                int charIndex = cc - 'a';
                return (nexts[charIndex] == null) ? false: nexts[charIndex].hasNext(s, index+1);
            }
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode current = root;
        return current.hasNext(word, 0);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");