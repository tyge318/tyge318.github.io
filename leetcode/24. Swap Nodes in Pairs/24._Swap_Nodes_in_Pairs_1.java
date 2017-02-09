/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current = head, curNext = (current == null) ? null: current.next;
        ListNode lastTail = head;
        while( curNext != null) {
            ListNode nextStart = curNext.next;
            ListNode curFirst = curNext;
            ListNode curSecond = current;
            curFirst.next = curSecond;
            curSecond.next = nextStart;
            if( current == head ) {
                head = curFirst;
                lastTail = curSecond;
            } 
            else {
                lastTail.next = curFirst;
                lastTail = curSecond;
            }
            System.out.println("current @" + current.val);
            current = nextStart;
            curNext = (current == null) ? null: current.next;
        }
        return head;
    }
}