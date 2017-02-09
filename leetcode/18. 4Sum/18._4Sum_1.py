class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        ans = []
        for i in xrange(len(nums)):
            for j in xrange(min(i+1, len(nums)-1), len(nums)):
                left = j+1
                right = len(nums)-1
                while left < right:
                    temp = nums[i]+nums[j]+nums[left]+nums[right]
                    if temp == target:
                        subans = [nums[i], nums[j], nums[left], nums[right]]
                        if subans not in ans:
                            ans.append(subans)
                        right -= 1
                        left += 1
                    elif temp > target:
                        right -= 1
                    else:
                        left += 1
        return ans
    
                    
                