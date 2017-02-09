class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        diff = float('inf')
        
        ans = 0
        for i, cur in enumerate(nums):
            left = i+1
            right = len(nums)-1
            while left < right:
                sum = cur+nums[left]+nums[right]
                if sum == target:
                    return target
                elif sum > target:
                    right -= 1
                    if sum-target < diff:
                        diff = sum-target
                        ans = sum
                else:
                    left += 1
                    if target-sum < diff:
                        diff = target-sum
                        ans = sum
        return ans
            
            