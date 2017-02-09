class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        result = []
        for i in xrange(num+1):
            binary = '{0:b}'.format(i)
            result.append(binary.count('1'))
        return result
        