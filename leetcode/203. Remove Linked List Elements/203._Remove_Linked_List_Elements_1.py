# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        
        last = dummy
        current = dummy.next
        
        while current:
            if current.val == val:
                last.next = current.next
            else:
                last = current
            current = current.next
        return dummy.next