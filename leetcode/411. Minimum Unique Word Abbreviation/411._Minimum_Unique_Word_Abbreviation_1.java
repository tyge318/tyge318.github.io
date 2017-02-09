public class Solution {
    class TrieNode {
        TrieNode[] next;
        boolean isWord;
        public TrieNode() {
            next = new TrieNode[26];
            isWord = false;
        }
    }
    class Trie {
        TrieNode root;
        public Trie(String[] dictionary) {
            root = new TrieNode();
            for(String w: dictionary)
                addWord(w);
        }
        public void addWord(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                int index = word.charAt(i)-'a';
                if( current.next[index] == null)
                    current.next[index] = new TrieNode();
                current = current.next[index];
            }
            current.isWord = true;
        }
        public boolean abbrConflict(String target, TrieNode node, int pos, int nums) {
            if( node == null)   return false;
            if( nums != 0 ) {
                for(int i=0; i<26; i++)
                    if( abbrConflict(target, node.next[i], pos, nums-1)) return true;
                return false;
            }
            if( pos == target.length() ) {
                if( node.isWord)    return true;
                return false;
            }
            if( Character.isDigit(target.charAt(pos)) ) {
                int temp = 0;
                while( pos < target.length() && Character.isDigit(target.charAt(pos)) ) {
                    temp = temp*10 + (target.charAt(pos) - '0');
                    pos++;
                }
                return abbrConflict(target, node, pos, temp);
            }
            else    return abbrConflict(target, node.next[target.charAt(pos)-'a'], pos+1, 0);
        }
    }
    List<String> abbrs;
    public String minAbbreviation(String target, String[] dictionary) {
        Trie root = new Trie(dictionary);
        for(int i=0; i<target.length(); i++) {
            abbrs = new ArrayList<>();
            generateAbbr(target, 0, "", 0, i+1);
            for(String s: abbrs)
                if( !root.abbrConflict(s, root.root, 0, 0) )   return s;
        }
        return "";
    }
    public void generateAbbr(String target, int i, String temp, int abbr, int num) {
        if(i==target.length()) {
            if(num==0&&abbr==0) abbrs.add(temp);
            if(num==1&&abbr!=0) abbrs.add(temp+abbr);
            return;
        }
        if(num<=0) return;
        char cur = target.charAt(i);
        generateAbbr(target, i+1, abbr==0?temp+cur:temp+abbr+cur, 0, abbr==0?num-1:num-2);
        generateAbbr(target, i+1, temp, abbr+1, num);
    }
}