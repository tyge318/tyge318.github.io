import random
class Solution(object):

    def __init__(self, nums):
        """
        
        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums;
        

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        candidates = []
        for index, i in enumerate(self.nums):
            if i == target:
                candidates.append(index);
        return candidates[random.randint(0, len(candidates)-1)]


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)