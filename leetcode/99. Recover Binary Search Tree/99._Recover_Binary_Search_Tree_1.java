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
    TreeNode aNode, bNode, prevNode;
    public void recoverTree(TreeNode root) {
        aNode = bNode = prevNode = null;
        findMistake(root);
        if( aNode != null && bNode != null) {
            int hold = aNode.val;
            aNode.val = bNode.val;
            bNode.val = hold;
        }
    }
    public void findMistake(TreeNode root) {
        if( root.left != null )
            findMistake(root.left);
        if( prevNode != null && prevNode.val > root.val) {
            if( aNode == null)
                aNode = prevNode;
            if( aNode != null)
                bNode = root;
        }
        prevNode = root;
        if( root.right != null)
            findMistake(root.right);
    }
}