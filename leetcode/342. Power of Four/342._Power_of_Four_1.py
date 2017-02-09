class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 0:
            return False
        binary = '{0:b}'.format(num)
        tokens = binary.split('1')
        return (len(tokens) == 2) and (len(tokens[-1]) % 2 == 0)
        