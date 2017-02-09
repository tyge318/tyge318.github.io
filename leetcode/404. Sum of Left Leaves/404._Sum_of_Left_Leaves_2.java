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
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if( root == null)
            return ans;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while( !st.empty()) {
            TreeNode current = st.pop();
            if( current.right != null )
                st.push(current.right);
            if( current.left != null ) {
                if( current.left.right == null && current.left.left == null)
                    ans += current.left.val;
                st.push(current.left);
            }
        }
        return ans;
    }
}