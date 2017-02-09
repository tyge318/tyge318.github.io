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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if( (p.val <= current.val && q.val >= current.val) || (q.val <= current.val && p.val >= current.val) )
                return current;
            else if( p.val <= current.val && q.val <= current.val)
                current = current.left;
            else if( p.val >= current.val && q.val >= current.val)
                current = current.right;
        }
        return current;
    }
}