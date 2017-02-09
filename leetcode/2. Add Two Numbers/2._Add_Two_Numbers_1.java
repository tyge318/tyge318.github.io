/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(carry);
        ListNode p1 = l1, p2 = l2, p3 = l3;
        while( p3 != null) {
            int curVal = ((p1 == null) ? 0: p1.val) + ((p2 == null) ? 0 : p2.val) + carry;
            carry = curVal / 10;
            p3.val = curVal % 10;
            ListNode nextDigit = new ListNode(carry);
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
            if(p1 == null && p2 == null && nextDigit.val == 0)
                break;
            p3.next = nextDigit;
            p3 = p3.next;
        }
        return l3;
    }
}