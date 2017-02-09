class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        n = len(num)
        for i in xrange(1, n/2+1):
            for j in xrange(1, n/2+1):
                if max(i, j) > n-i-j:
                    break;
                if self.valid(num, i, j):
                    return True
        return False
        
    def valid(self, num, i, j):
        if num[0] == '0' and i > 1:
            return False
        if num[i] == '0' and j > 1:
            return False
        
        sum = ''
        a = int(num[:i])
        b = int(num[i:i+j])
        k = i+j
        while k < len(num):
            c = a + b
            sum = str(c)
            a = b
            b = c
            if num[k:k+len(sum)] != sum:
                return False
            k += len(sum)
        return True
        