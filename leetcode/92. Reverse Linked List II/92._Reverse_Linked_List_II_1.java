/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int position = 0;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode rHead = null, rEnd = null;
        ListNode current = dummy, backPtr = rEnd;
        
        boolean set = false;
        while( current != null) {
            ListNode hold = null;
            boolean holdSet = false;
            if( position == m-1) {
                rHead = current;
            }
            if( position >= m && position <= n) {
                hold = current.next;
                holdSet = true;
                current.next = backPtr;
                backPtr = current;
                if( position == m) {
                    rEnd = backPtr;
                    rEnd.next = null;
                }
            }
            if( position == n+1) {
                rHead.next = backPtr;
                rEnd.next = current;
                set = true;
            }
            position++;
            current = holdSet ? hold : current.next;
        }
        if( !set ) {
            rHead.next = backPtr;
            rEnd.next = null;
        }
        return dummy.next;
    }
}