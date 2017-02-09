/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode current = head;
        while( current != null ) {
            st.push(current);
            current = current.next;
        }
        
        int carry = 1;
        while( !st.empty()) {
            current = st.pop();
            current.val += carry;
            carry = current.val / 10;
            current.val %= 10;
        }
        if( carry == 1) {
            ListNode hold = head;
            head = new ListNode(1);
            head.next = hold;
        }
        return head;
    }
}