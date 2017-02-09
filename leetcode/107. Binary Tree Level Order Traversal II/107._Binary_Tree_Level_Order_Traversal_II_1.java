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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null)
            return ans;
        build(root, 0, ans);
        return ans;
    }
    public void build(TreeNode root, int level, List<List<Integer>> ans) {
        if( ans.size() == level ) {
            List<Integer> current = new ArrayList<Integer>();
            current.add(root.val);
            ans.add(0, current);
        }
        else {
            List<Integer> current = ans.get(ans.size()-1-level );
            current.add(root.val);
        }
        if( root.left != null )
            build(root.left, level+1, ans);
        if( root.right != null)
            build(root.right, level+1, ans);
    }
}