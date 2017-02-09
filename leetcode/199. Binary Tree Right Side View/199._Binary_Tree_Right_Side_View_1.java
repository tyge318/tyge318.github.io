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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null)
            return ans;
            
        List<LinkedList<TreeNode>> hold = new ArrayList<LinkedList<TreeNode>>();
        hold.add(new LinkedList<TreeNode>());
        hold.add(new LinkedList<TreeNode>());
        int layer = 0;
        hold.get(0).add(root);
        while( !hold.get(0).isEmpty() || !hold.get(1).isEmpty() ) {
            LinkedList<TreeNode> currentLayer = hold.get(layer%2);
            LinkedList<TreeNode> nextLayer = hold.get((layer+1)%2);
            boolean rightMost = (currentLayer.size() == 1);
            TreeNode current = currentLayer.poll();
            if( rightMost) {
                ans.add(current.val);
                layer++;
            }
            if( current.left != null)
                nextLayer.add(current.left);
            if( current.right != null)
                nextLayer.add(current.right);
            
        }
        return ans;
    }
}