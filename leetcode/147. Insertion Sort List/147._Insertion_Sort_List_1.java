/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if( head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode unsortedHead = head.next;
        head.next = null;
        ListNode cursor, current;
        while( unsortedHead != null ) {
            cursor = dummyHead;
            current = unsortedHead;
            unsortedHead = current.next;
            current.next = null;
            boolean inserted = false;
            while( cursor != null && cursor.next != null ) {
                if(!inserted && current.val >= cursor.val && current.val < cursor.next.val ) {
                    current.next = cursor.next;
                    cursor.next = current;
                    inserted = true;
                    break;
                }    
                cursor = cursor.next;
            }
            if(!inserted) {
                cursor.next = current;
            }
        }
        return dummyHead.next;
    }
}