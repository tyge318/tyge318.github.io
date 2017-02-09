class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        dict = {}
        for index, i in enumerate(nums):
            dict.setdefault(i, []).append(index)
            if len(dict[i]) >= 2:
                if dict[i][-1] - dict[i][-2] <= k:
                    return True
        return False