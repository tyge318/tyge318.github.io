class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        for i in [50, 15, 10, 6, 5, 3, 2]:
            while (num % i == 0):
                num /= i
        return (num == 1)