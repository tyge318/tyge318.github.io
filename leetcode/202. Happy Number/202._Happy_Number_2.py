class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        self.trace = []
        return self.check(n)
                
    def check(self, n):
        if n in self.trace:
            #print 'n = ', n, 'trace = ', self.trace
            return False
        else:
            self.trace.append(n)
        sum = 0
        while n > 0:
            digit = n % 10
            n /= 10
            sum += digit ** 2
        if sum == 1:
            return True
        else:
            return self.check(sum)