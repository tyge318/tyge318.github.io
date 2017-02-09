# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        last = None
        current = head
        while current:
            hold = current.next
            current.next = last
            last = current
            current = hold
        return last