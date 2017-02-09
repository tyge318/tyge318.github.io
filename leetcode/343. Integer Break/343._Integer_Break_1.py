class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        opt = None
        if n<=7:
            opt = [0]*8
        else:
            opt = [0]*(n+1)
        opt[1] = 1
        opt[2] = 1
        opt[3] = 2
        opt[4] = 4
        opt[5] = 6
        opt[6] = 9
        opt[7] = 12
        for i in xrange(8, n+1):
            opt[i] = max(opt[i-2]*2, opt[i-3]*3)
        #print opt
        return opt[n]
        