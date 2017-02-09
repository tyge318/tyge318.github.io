class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1 or numRows >= len(s):
            return s
        
        matrix = [[] for x in xrange(numRows)]
        x, dx = 0, 1
        for index, c in enumerate(s):
            matrix[x] += c
            if x == 0:
                dx = 1
            elif x == numRows-1:
                dx = -1
            x += dx
        return "".join(reduce(operator.add, matrix))