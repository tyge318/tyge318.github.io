class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = 0
        m = 1
        while m<=n:
            a = n/m
            b = n%m
            ans += (a+8)/10*m
            ans += (b+1) if (a % 10 == 1) else 0
            m *= 10
        return ans