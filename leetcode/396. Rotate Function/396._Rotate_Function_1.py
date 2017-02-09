class Solution(object):
    def maxRotateFunction(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        size = len(A)
        sumA = sum(A)
        sumAW = sum(w*i for w, i in enumerate(A))
        ans = sumAW
        for i in xrange(size-1, 0, -1):
            sumAW += sumA - size*A[i]
            ans = max(ans, sumAW)
        return ans
        