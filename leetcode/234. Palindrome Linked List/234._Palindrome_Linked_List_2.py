# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        nodes = []
        ptr = head
        while ptr:
            nodes.append(ptr.val)
            ptr = ptr.next
        reverse = nodes[::-1]
        for index, i in enumerate(nodes):
            if i != reverse[index]:
                return False
        return True