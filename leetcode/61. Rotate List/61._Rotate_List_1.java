/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode last = head;
        int length = 1;
        while(last.next != null) { 
            last = last.next;
            length++;
        }
        if( k >= length )
            k %= length;
        ListNode newLast = head;
        int counter = 0;
        while( counter < length - k - 1) {
            newLast = newLast.next;
            counter++;
        }
        last.next = head;
        head = newLast.next;
        newLast.next = null;
        
        return head;
    }
}