/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if( head == null)
            return null;
        RandomListNode current = head;
        while( current != null ) {
            RandomListNode temp = new RandomListNode(current.label);
            temp.next = current.next;
            current.next = temp;
            current = temp.next;
        }
        current = head;
        while( current != null ) {
            RandomListNode copyNode = current.next;
            copyNode.random = (current.random == null) ? null : current.random.next;
            current = copyNode.next;
        }
        current = head;
        RandomListNode copyHead = head.next, copyCurrent;
        while( current != null && current.next != null ) {
            copyCurrent = current.next;
            current.next = copyCurrent.next;
            current = copyCurrent;
        }
        return copyHead;
    }
}