public class Solution {
    class TrieNode {
        TrieNode[] nexts;
        boolean isWord;
        public TrieNode() {
            nexts = new TrieNode[26];
            isWord = false;
        }
    }
    class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            for(String s: words)
                insert(s);
        }
        public void insert(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                int index = word.charAt(i)-'a';
                if( current.nexts[index] == null)
                    current.nexts[index] = new TrieNode();
                current = current.nexts[index];
            }
            current.isWord = true;
        }
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for(int i=0; i<prefix.length(); i++) {
                int index = prefix.charAt(i)-'a';
                if( current.nexts[index] == null)   return false;
                current = current.nexts[index];
            }
            return true;
        }
        public boolean hasWord(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                int index = word.charAt(i)-'a';
                if( current.nexts[index] == null)   return false;
                current = current.nexts[index];
            }
            return current.isWord;
        }
    }
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Set<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = (m == 0) ? 0: board[0].length;
        
        if( m == 0) return (new ArrayList<>());
        Trie dict = new Trie(words);
        boolean[][] visited = new boolean[m][n];
        ans = new HashSet<>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                search(board, visited, dict, "", i, j);
            }
        }
        return (new ArrayList<String>(ans));
    }
    public void search(char[][] board, boolean[][] visited, Trie dict, String prefix, int i, int j) {
        if( i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        prefix += board[i][j];
        if( !dict.startsWith(prefix) )  return;
        if( dict.hasWord(prefix) )
            ans.add(prefix);
        
        visited[i][j] = true;
        for(int k=0; k<4; k++)
            search(board, visited, dict, prefix, i+dx[k], j+dy[k]);
        visited[i][j] = false;
    }
}