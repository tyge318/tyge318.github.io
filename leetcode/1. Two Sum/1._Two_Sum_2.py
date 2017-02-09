class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i in xrange(len(nums)):
            temp = self.findTargetIndex(nums, i, target-nums[i])
            if temp != -1:
                return [i, temp]
        return None
        
    def findTargetIndex(self, nums, skipIndex, target):
        for i in xrange(len(nums)):
            if i == skipIndex:
                continue
            if nums[i] == target:
                return i
        return -1