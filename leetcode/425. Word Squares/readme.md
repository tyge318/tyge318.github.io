Recursively try every word to find every possible combination. The key is to be able to quickly know what choices do we have given current state.   
<img src="https://discuss.leetcode.com/uploads/files/1476809120456-wordsquare.png" width="1200"/>
Number of word choices are directly decided by their prefix. Hence, `Trie` is a good choice here.  
When we currently have $$k$$ words, the next word's prefix will be the $$k^{th}$$ letter of all words in top-down order. Use `StringBuilder` to generate this prefix and retrieve candidates of next word from the Trie.  
Time Complexity: $$O(n^2)$$