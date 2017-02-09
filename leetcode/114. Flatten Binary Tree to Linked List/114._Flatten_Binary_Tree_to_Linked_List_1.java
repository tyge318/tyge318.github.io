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
    public void flatten(TreeNode root) {
        root = flat(root);
    }
    public TreeNode flat(TreeNode root) {
        if( root == null )  return null;
        if( root.left == null && root.right == null) {
            return root;
        }
        TreeNode right = flat(root.right);
        if( root.left != null) {
            TreeNode left = flat(root.left);
            root.left = null;
            root.right = left;
            while( left.right != null ) {
                left = left.right;
            }
            left.right = right;
        }
        return root;
    }
}