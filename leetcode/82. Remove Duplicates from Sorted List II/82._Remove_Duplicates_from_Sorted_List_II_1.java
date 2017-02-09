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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while( current != null ) {
            ListNode next = current.next;
            if( next == null)
                break;
            ListNode nextNext = next.next;
            while( nextNext != null && nextNext.val == next.val  ) 
                nextNext = nextNext.next;
            if(next.next != nextNext)
                current.next = nextNext;
            else
                current = current.next;
        }
        return dummy.next;
    }
}