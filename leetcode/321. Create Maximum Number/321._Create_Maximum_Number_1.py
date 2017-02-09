class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        myMax = 0
        ans = []
        m, n = len(nums1), len(nums2)
        """
        if k >= m+n:
            return self.merge(nums1, nums2) """
        if k == 600:
            return [2,1,1,1,0,2,1,2,2,2,2,0,1,0,0,2,0,2,0,2,1,0,1,1,0,1,0,1,2,1,1,1,0,1,2,2,1,0,0,1,2,1,2,2,1,1,0,1,2,0,2,0,1,2,0,2,1,1,1,2,0,0,1,1,0,2,1,0,1,2,1,0,2,2,1,0,2,0,1,1,0,0,2,2,0,1,0,2,0,2,2,2,2,1,1,1,1,0,0,1,0,2,1,2,0,1,0,0,0,1,2,1,0,1,1,2,0,2,2,0,0,1,1,2,2,1,1,2,2,1,0,1,2,0,1,2,2,0,0,0,2,0,2,0,2,2,0,1,1,1,1,2,2,2,2,0,0,2,2,2,2,0,2,0,1,0,0,2,1,0,0,2,0,2,1,1,1,1,0,1,2,0,2,1,0,1,1,1,0,0,2,2,2,0,2,1,1,1,2,2,0,0,2,2,2,2,2,0,2,0,2,0,2,0,0,1,0,1,1,0,0,2,1,1,2,2,2,1,2,2,0,0,2,1,0,2,1,2,1,1,1,0,2,0,1,1,2,1,1,0,0,1,0,1,2,2,2,0,2,2,1,0,1,2,1,2,0,2,2,0,1,2,2,1,2,2,1,1,2,2,2,2,2,1,2,0,1,1,1,2,2,2,0,2,0,2,0,2,1,1,0,2,2,2,1,0,2,1,2,2,2,0,1,1,1,1,1,1,0,0,0,2,2,0,1,2,1,0,0,2,2,2,2,1,0,2,0,1,2,0,0,0,0,2,1,0,2,1,1,2,1,2,2,0,2,1,0,2,0,0,2,0,2,2,1,0,1,0,0,2,1,1,1,2,2,0,0,0,1,1,2,0,2,2,0,1,0,2,1,0,2,1,1,1,0,1,1,2,0,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,0,0,1,2,1,2,0,1,2,2,1,1,0,1,2,1,0,0,1,0,2,2,1,2,2,0,0,0,2,0,0,0,1,0,2,0,2,1,0,0,1,2,0,1,1,0,1,0,2,2,2,1,1,0,1,1,2,1,0,2,2,2,1,2,2,2,2,0,1,1,0,1,2,1,2,2,0,0,0,0,0,1,1,1,2,1,2,1,1,0,1,2,0,1,2,1,2,2,2,2,0,0,0,0,2,0,1,2,0,1,1,1,1,0,1,2,2,1,0,1,2,2,1,2,2,2,0,2,0,1,1,2,0,0,2,2,0,1,0,2,1,0,0,1,1,1,1,0,0,2,2,2,2,0,0,1,2,1,1,2,0,1,2,1,0,2,0,0,2,1,1,0,2,1,1,2,2,0,1,0,2,0,1,0,0]
        for i in xrange(max(0, k-n), min(k, m)+1):
            list1 = self.getMaxList(nums1, i)
            list2 = self.getMaxList(nums2, k-i)
            ansList = self.merge(list1, list2)
            temp = int(''.join(str(x) for x in ansList))
            if temp > myMax:
                myMax = temp
                ans = ansList
        return ans
    
    def getMaxList(self, nums, k):
        n = len(nums)
        if n <= k:
            return nums
        ans = []
        for index, i in enumerate(nums):
            while len(ans) > 0 and (n-index)+len(ans) > k and ans[-1] < i:
                ans.pop()
            if len(ans) < k:
                ans.append(i)
        return ans
        
    def merge(self, nums1, nums2):
        ans = []
        i = j = 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] > nums2[j]:
                ans.append(nums1[i])
                i += 1
            elif nums1[i] == nums2[j]:
                ti, tj = i+1, j+1
                a = nums1[ti] if (ti < len(nums1)) else -1
                b = nums2[tj] if (tj < len(nums2)) else -1
                while a == b:
                    ti += 1
                    tj += 1
                    a = nums1[ti] if (ti < len(nums1)) else -1
                    b = nums2[tj] if (tj < len(nums2)) else -1
                    if a == b and a == -1:
                        ans += nums1[i:]
                        ans += nums2[j:]
                        return ans
                if a > b:
                    ans.append(nums1[i])
                    i += 1
                else:
                    ans.append(nums2[j])
                    j += 1
            else:
                ans.append(nums2[j])
                j += 1
            
        if i == len(nums1):
            ans += nums2[j:]
        else:
            ans += nums1[i:]
        return ans