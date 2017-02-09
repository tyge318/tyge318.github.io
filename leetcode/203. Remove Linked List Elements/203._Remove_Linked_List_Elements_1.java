/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(-1); //dummy node
        dummy.next = head;
        ListNode current = dummy;
        while(current != null && current.next != null) {
            if(current.next.val == val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}