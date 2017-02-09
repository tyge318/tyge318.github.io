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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode build(int[] inorder, int si, int ei, int[] postorder, int sp, int ep) {
        if( sp > ep || si > ei)
            return null;
        TreeNode root = new TreeNode(postorder[ep]);
        for(int i=si; i<=ei; i++) {
            if( inorder[i] == postorder[ep]) {
                root.left = build(inorder, si, i-1, postorder, sp, sp+i-si-1);
                root.right = build(inorder, i+1, ei, postorder, sp+i-si, ep-1);
            }
        }
        return root;
    }
}