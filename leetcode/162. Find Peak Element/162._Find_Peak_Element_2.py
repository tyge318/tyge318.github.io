class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        for index, i in enumerate(nums):
            if index == 0 and nums[index+1] < i:
                return index
            if index == len(nums)-1 and nums[index-1] < i:
                return index
            if nums[index-1] < i and nums[index+1] < i:
                return index
                
        