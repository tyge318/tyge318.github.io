/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy, nonNine = dummy;
        while( current != null) {
            if( current.val != 9)
                nonNine = current;
            current = current.next;
        }
        
        nonNine.val++;
        nonNine = nonNine.next;
        while( nonNine != null ) {
            nonNine.val = 0;
            nonNine = nonNine.next;
        }
        
        return (dummy.val == 0) ? dummy.next: dummy;
    }
}