/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, last = null, next;
        while( current != null) {
            next = current.next;
            current.next = last;
            last = current;
            current = next;
        }
        return last;
    }
}