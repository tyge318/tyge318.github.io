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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int rootMax = compute(root);
        return max;
    }
    public int compute(TreeNode root) { //return the max ends in root.
        if( root == null)   return 0;
        int leftMax = compute(root.left);
        int rightMax =compute(root.right);
        
        int myRootMax = Math.max(root.val, Math.max(root.val+leftMax, root.val+rightMax));  //find max value for paths ends in root
        max = Math.max(max, Math.max(myRootMax, leftMax+root.val+rightMax)); // max might be in a path where root is the mid point.
        return myRootMax;
    }
}