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
        if( head == null || head.next == null)
            return head;
        if( head.next.next == null) {
            ListNode a = head, b = head.next;
            if( b.val < a.val ) {
                a.next = null;
                b.next = a;
                return b;
            }
            return a;
        }
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        head = sortList(head);
        right = sortList(right);
        head = mergeTwoLists(head, right);
        return head;
    }
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while( fast.next != null && fast.next.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        ListNode head, ptr, l1ptr = l1, l2ptr = l2;
        if( l1.val < l2.val) {
            head = l1;
            l1ptr = l1ptr.next;
        }
        else{
            head = l2;
            l2ptr = l2ptr.next;
        }
        ptr = head;
        while( l1ptr != null && l2ptr != null) {
            if( l1ptr.val < l2ptr.val) {
                ptr.next = l1ptr;
                l1ptr = l1ptr.next;
            }
            else {
                ptr.next = l2ptr;
                l2ptr = l2ptr.next;
            }
            ptr = ptr.next;
        }
        if( l1ptr == null ) {
            ptr.next = l2ptr;
        }
        else {
            ptr.next = l1ptr;
        }
        return head;
    }
}