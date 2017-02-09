# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        lenA = self.getLen(headA)
        lenB = self.getLen(headB)
        
        if lenA < lenB: #ensures len(A) always > len(B)
            headA, headB = headB, headA #swap
            lenA, lenB = lenB, lenA
            
        pA = headA
        pB = headB
        counter = 0
        while counter < 2*lenA:
            if not pA:
                pA = headB
            if not pB:
                pB = headA
            if pA.val == pB.val:
                return pA
            pA = pA.next
            pB = pB.next
            counter += 1
        return None
        
    def getLen(self, headList):
        counter = 0
        p = headList
        while p:
            p = p.next
            counter += 1
        return counter
            
            
                