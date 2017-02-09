import java.lang.Math.*;

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
    public int rob(TreeNode root) {
        return myBest(root);
    }
    public int myBest(TreeNode node) {
        if(node == null)
            return 0;
        else if(node.left == null && node.right == null)
            return node.val;
        else {
            return Math.max(node.val + nextBest(node.left, node.right), myBest(node.left) + myBest(node.right) );
        }
    }
    public int nextBest(TreeNode left, TreeNode right) {
        if(left == null)
            return myBest(right.left)+myBest(right.right);
        else if (right == null)
            return myBest(left.left)+myBest(left.right);
        else
            return myBest(right.left)+myBest(right.right)+myBest(left.left)+myBest(left.right);
    }
}