class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        smallest = None
        smaller = None
        for i in nums:
            if smallest is None or smallest >= i:
                smallest = i
            elif smaller is None or smaller >= i:
                smaller = i
            else:
                return True
        return False