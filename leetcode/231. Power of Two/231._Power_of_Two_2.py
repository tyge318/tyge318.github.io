class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        bitString = bin(n)
        
        return (n >= 1) and (bitString.count('1') == 1)
        
        