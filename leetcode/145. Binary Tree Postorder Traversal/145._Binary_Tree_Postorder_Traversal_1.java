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
    public List<Integer> postorderTraversal(TreeNode root) {
        return recursive(root);
    }
    public List<Integer> recursive(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null )
            return ans;
        ans.addAll(recursive(root.left) );
        ans.addAll(recursive(root.right) );
        ans.add(root.val);
        return ans;
    }
    public List<Integer> iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null )
            return ans;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while( !st.empty() ) {
            TreeNode current = st.peek();
            if( current.right == null && current.left == null ) {
                st.pop();
                ans.add(current.val);
            }
            if( current.right != null ) {
                st.push(current.right);
                current.right = null;
            }
            if( current.left != null ) {
                st.push(current.left);
                current.left = null;
            }
        }
        return ans;
    }
}