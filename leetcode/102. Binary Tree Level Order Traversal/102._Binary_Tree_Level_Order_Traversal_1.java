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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null )  return ans;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while( !q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<Integer>();
            for(int i=0; i<size; i++) {
                TreeNode current = q.poll();
                currentLevel.add(current.val);
                if( current.left != null)
                    q.add(current.left);
                if( current.right != null)
                    q.add(current.right);
            }
            ans.add(currentLevel);
        }
        return ans;
    }
}