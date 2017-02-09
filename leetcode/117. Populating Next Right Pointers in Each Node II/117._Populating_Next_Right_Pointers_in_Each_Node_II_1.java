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
            connect(root.left);
            connect(root.right);
            TreeLinkNode leftBegin = root.left, rightBegin = root.right;
            while( leftBegin != null && rightBegin != null) {
                TreeLinkNode leftEnd = leftBegin;
                while(leftEnd.next != null) leftEnd = leftEnd.next;
                leftEnd.next = rightBegin;
                while( leftBegin.left == null && leftBegin.right == null) {
                    if( leftBegin.next == rightBegin) break;
                    leftBegin = leftBegin.next;
                }
                leftBegin = (leftBegin.left == null) ? leftBegin.right : leftBegin.left;
                while( rightBegin.left == null && rightBegin.right == null) {
                    if( rightBegin.next == null) break;
                    rightBegin = rightBegin.next;
                }
                rightBegin = (rightBegin.left == null) ? rightBegin.right : rightBegin.left;
            }
        }
    }
}