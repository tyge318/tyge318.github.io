class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        def c(m, n):
            h = 1
            for x in xrange(m, m-n, -1):
                h *= x
            k = 1
            for x in xrange(n, 0, -1):
                k *= x
            return (h/k)
        return c((m-1)+(n-1), n-1)
