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
    public List<Integer> preorderTraversal(TreeNode root) {
        return iterative(root);
    }
    public List<Integer> iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null)
            return ans;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while( !st.empty() ) {
            TreeNode current = st.pop();
            ans.add(current.val);
            if(current.right != null)
                st.push(current.right);
            if(current.left != null)
                st.push(current.left);
        }
        return ans;
    }
    public List<Integer> recursive(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null )
            return ans;
        ans.add(root.val);
        ans.addAll(recursive(root.left) );
        ans.addAll(recursive(root.right) );
        return ans;
    }
}