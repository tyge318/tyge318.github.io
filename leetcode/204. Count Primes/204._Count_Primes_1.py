class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return 0
        isPrime = [True for i in xrange(n)]
        isPrime[0], isPrime[1] = False, False
        
        i = 2
        while i*i < n:
            if isPrime[i] == False:
                i += 1
                continue
            for j in xrange(i*i, n, i):
                isPrime[j] = False
            i += 1
        return isPrime.count(True)