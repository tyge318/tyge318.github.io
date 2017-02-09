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
    int ans;
    public int longestConsecutive(TreeNode root) {
        if( root == null)
            return 0;
        dfs(Integer.MIN_VALUE, 1, root);
        return ans;
    }
    public void dfs(int parentVal, int len, TreeNode root) {
        if( parentVal == Integer.MIN_VALUE) 
            ans = 1;
        else if(parentVal+1 == root.val)
            len++;
        else
            len = 1;
        ans = Math.max(ans, len);
        if( root.left != null )
            dfs(root.val, len, root.left);
        if( root.right != null )
            dfs(root.val, len, root.right);
    }
}