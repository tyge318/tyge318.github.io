class Solution(object):
    def reverseBits(self, n):
        """
        :type n: int
        :rtype: int
        """
        bs = '{0:032b}'.format(n)
        return int(bs[::-1], 2)
        