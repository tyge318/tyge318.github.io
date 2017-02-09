class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        i32_min = -2147483648
        i32_max = 2147483647
        signed = 1 if x >= 0 else -1
        reverseNum = int(str(signed*x)[::-1])*signed
        
        return (reverseNum if (reverseNum >= i32_min and reverseNum <= i32_max) else 0)
        