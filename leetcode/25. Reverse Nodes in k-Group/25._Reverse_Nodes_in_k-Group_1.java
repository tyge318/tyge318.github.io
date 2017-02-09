/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if( k< 2 )
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        while( ptr.next != null && ptr.next.next != null) {
            ListNode previous = ptr.next, current = previous.next;
            int i=0;
            while( current != null && i<k-1) {
                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
                i++;
            }
            
            if( i== k-1) {
                ListNode temp = ptr.next;
                ptr.next.next = current;
                ptr.next = previous;
                ptr = temp;
            }
            else {
                current = previous.next;
                previous.next = null;
                while( current != ptr.next) {
                    ListNode temp = current.next;
                    current.next = previous;
                    previous = current;
                    current = temp;
                }
                break;
            }
        }
        return dummy.next;
    }
}