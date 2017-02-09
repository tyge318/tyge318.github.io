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
        ListNode ans = null;
        Stack<Integer> dl1 = new Stack<>();
        Stack<Integer> dl2 = new Stack<>();
        
        while(!(l1 == null && l2 == null) ) {
            if( l1 != null ) {
                dl1.push(l1.val);
                l1 = l1.next;
            }
            if( l2 != null ) {
                dl2.push(l2.val);
                l2 = l2.next;
            }
        }
        int carry = 0;
        while( !(dl1.isEmpty() && dl2.isEmpty()) ) {
            int d1 = dl1.isEmpty() ? 0 : dl1.pop();
            int d2 = dl2.isEmpty() ? 0 : dl2.pop();
            int sum =  carry + d1 + d2;
            carry = sum / 10;
            ListNode current = new ListNode(sum % 10);
            current.next = ans;
            ans = current;
        }
        if( carry != 0 ) {
            ListNode current = new ListNode(1);
            current.next = ans;
            ans = current;
        }
        return ans;
    }
}