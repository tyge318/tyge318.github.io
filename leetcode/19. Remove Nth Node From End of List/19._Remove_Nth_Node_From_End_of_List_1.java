/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head, s_prev = head;
        int f_index = 0, s_index = 0;
        while( fast != null) {
            fast = fast.next;
            if( f_index - s_index == n) {
                s_prev = slow;
                slow = slow.next;
                s_index++;
            }
            f_index++;
        }
        if(s_prev == slow) {
            head = slow.next;
        }
        else
            s_prev.next = slow.next;
        return head;
    }
}