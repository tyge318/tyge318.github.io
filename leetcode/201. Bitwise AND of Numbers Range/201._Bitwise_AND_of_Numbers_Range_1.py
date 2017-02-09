class Solution(object):
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        diff = n-m
        tailZeros = 0
        while diff > 0:
            diff = diff >> 1
            tailZeros += 1
        mask = (~0) << tailZeros
        return m & n & mask