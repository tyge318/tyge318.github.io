/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)   //length == 0 or 1
            return head;
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(rightHead) );
    }
    public ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(leftHead != null && rightHead != null) {
            if(leftHead.val < rightHead.val) {
                current.next = leftHead;
                leftHead = leftHead.next;
            }
            else {
                current.next = rightHead;
                rightHead = rightHead.next;
            }
            current = current.next;
        }
        if(leftHead == null)
            current.next = rightHead;
        else
            current.next = leftHead;
        return head.next;
    }
    public ListNode getMiddle(ListNode head) {
        if(head == null)
            return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}