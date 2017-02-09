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
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        /*
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
        return currentLevel; */
        dfs(root, 1);
        return (minDepth == Integer.MAX_VALUE) ? 0 : minDepth;
    }
    public void dfs(TreeNode root, int level) {
        if( root == null )  return;
        if( root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, level);
            return;
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}