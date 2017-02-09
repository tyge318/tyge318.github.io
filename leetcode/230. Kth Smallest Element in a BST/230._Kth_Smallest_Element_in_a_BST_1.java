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
    List<Integer> trace;
    public int kthSmallest(TreeNode root, int k) {
        trace = new ArrayList<Integer>();
        inorderWalk(root, k);
        return trace.get(k-1);
    }
    public void inorderWalk(TreeNode root, int k) {
        if( root == null || trace.size() >= k)
            return;
        inorderWalk(root.left, k);
        trace.add(root.val);
        inorderWalk(root.right, k);
    }
}