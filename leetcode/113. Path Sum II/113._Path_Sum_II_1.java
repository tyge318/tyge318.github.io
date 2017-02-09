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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null)
            return ans;
        if( root.left == null && root.right == null ) {
            if( root.val == sum ) {
                List<Integer> current = new ArrayList<Integer>();
                current.add(sum);
                ans.add(current);
                return ans;
            }
            else
                return ans;
        }
        List<List<Integer>> leftsubs = pathSum(root.left, sum-root.val);
        if( !leftsubs.isEmpty() )
            ans.addAll(leftsubs);
        List<List<Integer>> rightsubs = pathSum(root.right, sum-root.val);
        if( !rightsubs.isEmpty() )
            ans.addAll(rightsubs);
        if( !ans.isEmpty()) {
            for( List<Integer> e: ans) {
                e.add(0, root.val);
            }
        }
        return ans;
    }
}