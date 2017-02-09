class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        OPT = [] 
        for i in xrange(len(nums)):
            if i == 0:
                OPT.append(nums[0])
                continue
            if i == 1:
                OPT.append(max(nums[0], nums[1]))
                continue
            current = max(OPT[i-1], nums[i] + OPT[i-2])
            OPT.append(current)
        
        if len(OPT):
            return OPT[-1]
        else:
            return 0
            