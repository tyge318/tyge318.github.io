/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if( head == null)
            return null;
        if( head.next == null)
            return (new TreeNode(head.val));
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = (mid == head) ? null: sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    public ListNode findMid(ListNode head) {
        if( head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if( fast.next == null)
                break;
            else
                fast = fast.next;
        }
        ListNode mid = slow;
        if( prev != null)
            prev.next = null;
        return mid;
    }
}