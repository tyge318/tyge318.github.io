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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    public TreeNode build(int[] preorder, int sp, int ep, int[] inorder, int si, int ei) {
        if( sp >= ep)
            return null;
            
        TreeNode root = new TreeNode(preorder[sp]);
        for(int i=si; i<ei; i++) {
            if( inorder[i] == preorder[sp]) {
                root.left = build(preorder, sp+1, sp+(i-si)+1, inorder, si, i);
                root.right = build(preorder, sp+(i-si)+1, ep, inorder, i+1, ei);
            }
        }
        return root;
    }
}