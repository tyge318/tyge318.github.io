/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head, ans = head;
        while( fast != null ) {
            fast = (fast.next == null) ? null : fast.next.next;
            slow = slow.next;
            if( fast == slow ) {
                while( slow != ans) {
                    slow = slow.next;
                    ans = ans.next;
                }
                return ans;
            }
        }
        return null;
    }
}