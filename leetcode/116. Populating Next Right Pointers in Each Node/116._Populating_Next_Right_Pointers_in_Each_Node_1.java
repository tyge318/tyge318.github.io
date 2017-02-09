/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if( root == null || (root.left == null && root.right == null) )
            return;
        else {
            TreeLinkNode leftEnd = root.left, rightBegin = root.right;
            while( leftEnd != null) {
                leftEnd.next = rightBegin;
                leftEnd = leftEnd.right;
                rightBegin = rightBegin.left;
            }
            connect(root.left);
            connect(root.right);
        }
    }
}