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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null )
            return ans;
        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left) );
        ans.addAll(preorderTraversal(root.right) );
        return ans;
    }
}