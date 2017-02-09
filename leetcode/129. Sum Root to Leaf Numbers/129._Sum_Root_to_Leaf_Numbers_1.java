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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        HashMap<TreeNode, Integer> vals = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        vals.put(root, root.val);
        int ans = 0;
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if( cur.left == null && cur.right == null)
                ans += vals.get(cur);
            else{
                TreeNode left = cur.left;
                if(left != null) {
                   vals.put(left, 10*vals.get(cur)+left.val);
                   q.add(left); 
                }
                TreeNode right = cur.right;
                if(right != null) {
                    vals.put(right, 10*vals.get(cur)+right.val);
                    q.add(right);
                }
            }
        }
        return ans;
    }
}