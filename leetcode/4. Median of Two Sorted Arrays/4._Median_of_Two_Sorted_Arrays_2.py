class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        total = len(nums1)+len(nums2)
        if total % 2 == 1:
            return self.findKth(nums1, nums2, 0, 0, total/2+1)
        else:
            return ((self.findKth(nums1, nums2, 0, 0, total/2) + self.findKth(nums1, nums2, 0, 0, total/2+1))/2.0)
        
    def findKth(self, a, b, aBegin, bBegin, k):
        if aBegin >= len(a):
            return b[bBegin+k-1]
        if bBegin >= len(b):
            return a[aBegin+k-1]
        if k == 1:
            return min(a[aBegin], b[bBegin]);
        
        mA = aBegin+k/2-1;
        mB = bBegin+k/2-1;
        
        midA = a[mA] if mA < len(a) else float("inf")
        midB = b[mB] if mB < len(b) else float("inf")
        
        if midA < midB:
            return self.findKth(a, b, mA+1, bBegin, k-k/2)
        else:
            return self.findKth(a, b, aBegin, mB+1, k-k/2)
        