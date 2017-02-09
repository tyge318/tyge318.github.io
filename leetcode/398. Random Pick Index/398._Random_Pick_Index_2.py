import random
class Solution(object):

    def __init__(self, nums):
        """
        
        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums;
        self.cacheId = None
        self.candidates = []

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        if self.cacheId != target:
            self.cacheId = target
            self.candidates[:] = []
            for index, i in enumerate(self.nums):
                if i == target:
                    self.candidates.append(index);
        return self.candidates[random.randint(0, len(self.candidates)-1)]


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)