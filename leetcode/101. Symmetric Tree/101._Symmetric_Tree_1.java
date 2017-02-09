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
    public boolean isSymmetric(TreeNode root) {
        if( root == null)
            return true;
        List<Integer> left = preOrderList(root.left, true);
        List<Integer> right = preOrderList(root.right, false);
        return left.equals(right);
    }
    public List<Integer> preOrderList(TreeNode root, boolean preOrder) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if( root == null) {
            ans.add(Integer.MIN_VALUE);
            return ans;
        }
        ans.add(root.val);
        if( preOrder )
            ans.addAll(preOrderList(root.left, preOrder));
        ans.addAll(preOrderList(root.right, preOrder));
        if( !preOrder )
            ans.addAll(preOrderList(root.left, preOrder));
        return ans;
    }
}