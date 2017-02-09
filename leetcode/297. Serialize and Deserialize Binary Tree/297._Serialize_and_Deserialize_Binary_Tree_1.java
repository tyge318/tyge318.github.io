/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if( root == null)
            return null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        StringBuilder temp = new StringBuilder();
        
        while(!st.isEmpty()) {
            TreeNode current = st.pop();
            if( current == null)
                temp.append("#,");
            else {
                temp.append(current.val+",");
                st.push(current.right);
                st.push(current.left);
            }
        }
        temp.deleteCharAt(temp.length()-1);
        return temp.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if( data == null)
            return null;
        
        int[] index = {0};  //index as an array in order to be passed as reference.
        String[] tokens = data.split(",");
        
        return reconstruct(tokens, index);
    }
    public TreeNode reconstruct(String[] tokens, int[] index) {
        if( tokens[index[0]].equals("#") )
            return null;
        
        TreeNode current = new TreeNode(Integer.parseInt(tokens[index[0]]) );
        index[0]++;
        current.left = reconstruct(tokens, index);
        index[0]++;
        current.right = reconstruct(tokens, index);
        return current;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));