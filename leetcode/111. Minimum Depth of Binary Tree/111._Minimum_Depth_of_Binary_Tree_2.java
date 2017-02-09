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
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<Integer> levelQ = new LinkedList<Integer>();
        if( root == null)
            return 0;
        int currentLevel = 1;
        q.add(root);
        levelQ.add(1);
        while(!q.isEmpty() ) {
            TreeNode current = q.poll();
            currentLevel = levelQ.poll();
            if( current.left == null && current.right == null) {
                return currentLevel;
            }
            if( current.left != null) {
                q.add(current.left);
                levelQ.add(currentLevel+1);
            }
            if( current.right != null) {
                q.add(current.right);
                levelQ.add(currentLevel+1);
            }
        }
        return currentLevel;
    }
}