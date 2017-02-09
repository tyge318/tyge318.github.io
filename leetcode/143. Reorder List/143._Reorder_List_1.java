/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if( head == null || head.next == null )
            return;
        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        rightHead = reverseList(rightHead);
        
        ListNode a = head, b = rightHead;
        while( a != null && b != null ) {
            ListNode hold = a.next;
            a.next = b;
            a = hold;
            hold = b.next;
            b.next = a;
            b = hold;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode current = head, last = null, next;
        int counter = 0;
        while( current != null ) {
            next = current.next;
            current.next = last;
            last = current;
            current = next;
            counter++;
        }
        return last;
    }
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while( fast.next != null && fast.next.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}