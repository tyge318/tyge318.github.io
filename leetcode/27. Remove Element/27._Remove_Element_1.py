class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        count = nums.count(val);
        counter = 0
        while counter != count:
            nums.remove(val);
            counter += 1;
        return len(nums)
        
        