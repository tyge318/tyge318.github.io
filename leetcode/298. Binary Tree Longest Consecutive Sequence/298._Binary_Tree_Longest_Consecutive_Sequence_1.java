/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if( root == null )
            return 0;
        dfs(root, 1);
        return maxLen;
    }
    public void dfs(TreeNode node, int len) {
        if( node.left != null) {
            if( node.left.val == node.val+1)
                dfs(node.left, len+1);
            else {
                maxLen = Math.max(maxLen, len);
                dfs(node.left, 1);
            }
        }
        else
            maxLen = Math.max(maxLen, len);
        if( node.right != null) {
            if( node.right.val == node.val+1)
                dfs(node.right, len+1);
            else {
                maxLen = Math.max(maxLen, len);
                dfs(node.right, 1);
            }
        }
        else
            maxLen = Math.max(maxLen, len);
    }
}