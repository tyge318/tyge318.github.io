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
    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        dfs(root, sum, false);
        return ans;
    }
    public void dfs(TreeNode root, int target, boolean began) {
        if( root == null) return;
        if( root.val == target) 
            ans++;
        if( root.left != null) {
            dfs(root.left, target - root.val, true); //including current node
            if( !began)
                dfs(root.left, target, false);    //not including current node
        }
        if( root.right != null) {
            dfs(root.right, target - root.val, true);
            if( !began )
                dfs(root.right, target, false);
        }
    }
}