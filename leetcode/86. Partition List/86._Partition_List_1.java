/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if( head == null)
            return head;
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        ListNode current = head, leftMove = leftHead, rightMove = rightHead;
        
        while( current != null) {
            if( current.val < x ) {
                leftMove.next = current;
                leftMove = leftMove.next;
            }
            else {
                rightMove.next = current;
                rightMove = rightMove.next;
            }
            current = current.next;
        }
        leftMove.next = rightHead.next;
        rightMove.next = null;
        return leftHead.next;
    }
}