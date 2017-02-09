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
    public int countNodes(TreeNode root) {
        if( root == null )
            return 0;
        int leftDeep = digLeft(root);
        int rightDeep = digRight(root);
        if( leftDeep == rightDeep)
            return ((1 << leftDeep)-1);
        return (1+countNodes(root.left)+countNodes(root.right));
    }
    public int digLeft(TreeNode root) {
        TreeNode current = root;
        int count = 0;
        while( current != null) {
            current = current.left;
            count++;
        }
        return count;
    }
    public int digRight(TreeNode root) {
        TreeNode current = root;
        int count = 0;
        while( current != null) {
            current = current.right;
            count++;
        }
        return count;
    }
    public int bfsCount(TreeNode root) {
        List<TreeNode> currentLayer = new LinkedList<TreeNode>();
        List<TreeNode> nextLayer = new LinkedList<TreeNode>();
        
        boolean reachLast = false;
        if( root == null )
            return 0;
        currentLayer.add(root);
        
        int ans = 0;
        while( currentLayer.size() > 0 ) {
            ans += currentLayer.size();
            for(int i=0; i<currentLayer.size(); i++) {
                TreeNode current = currentLayer.get(i);
                if( current.left != null && current.right != null) { //next layer is not last layer
                    nextLayer.add(current.left);
                    nextLayer.add(current.right);
                }
                else {  //next layer is the last layer
                    reachLast = true;
                    if( current.left != null)
                        nextLayer.add(current.left);
                    if( current.right != null)
                        nextLayer.add(current.right);
                }
            }
            currentLayer.clear();
            if( !reachLast ) { 
                currentLayer.addAll(nextLayer);
                nextLayer.clear();
            }
        }
        ans += nextLayer.size();
        return ans;
    }
    
}