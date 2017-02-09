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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null )
            return ans;
        addToLevel(root, ans, 0);
        return ans;
    }
    public void addToLevel(TreeNode root, List<List<Integer>> ans, int level) {
        if( ans.size() == level) {
            List<Integer> current = new ArrayList<Integer>();
            if( level % 2 == 0)
                current.add(root.val);
            else
                current.add(0, root.val);
            ans.add(current);
        }
        else {
            List<Integer> current = ans.get(level);
            if( level % 2 == 0)
                current.add(root.val);
            else
                current.add(0, root.val);
        }
        if( root.left != null )
            addToLevel(root.left, ans, level+1);
        if( root.right != null)
            addToLevel(root.right, ans, level+1);
    }
}