/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode current = dummy;
        while( current != null) {
            ListNode next = current.next;
            while(next != null && next.val == current.val)
                next = next.next;
            current.next = next;
            current = current.next;
        }
        return dummy.next;
    }
}