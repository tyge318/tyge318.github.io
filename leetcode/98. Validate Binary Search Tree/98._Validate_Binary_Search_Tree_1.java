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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean isValid(TreeNode root, long max, long min) {
        if( root == null)
            return true;
        if( (long)root.val >= max || (long)root.val <= min)
            return false;
        return (isValid(root.left, root.val, min) && isValid(root.right, max, root.val));
    }
}