/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder x = new StringBuilder();
        ListNode ptr = head;
        while(ptr != null) {
            x.append(String.valueOf(ptr.val) + " ");
            ptr = ptr.next;
        }
        String forward = x.toString().trim();
        String[] tokens = forward.split(" ");
        for(int i=0; i<tokens.length/2; i++) {
            if( !tokens[i].equals(tokens[tokens.length-i-1]) )
                return false;
        }
        return true;
        
    }
}