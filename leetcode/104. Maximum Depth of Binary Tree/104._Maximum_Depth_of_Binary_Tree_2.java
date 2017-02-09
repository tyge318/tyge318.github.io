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
    int maxDepth;
    public int maxDepth(TreeNode root) {
        if( root == null)
            return 0;
        maxDepth = 1;
        findDepth(root, 1);
        return maxDepth;
    }
    public void findDepth(TreeNode root, int level) {
        maxDepth = Math.max(level, maxDepth);
        if( root.left != null )
            findDepth(root.left, level+1);
        if( root.right != null)
            findDepth(root.right, level+1);
    }
}