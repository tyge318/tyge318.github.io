class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        trace = [1]
        counter = 1
        index2 = index3 = index5 = 0
        while len(trace) < n:
            a, b, c = trace[index2]*2, trace[index3]*3, trace[index5]*5
            current = min(a, b, c)
            if current == a:
                index2 += 1
            if current == b:
                index3 += 1
            if current == c:
                index5 += 1
            trace.append(current)
        #print trace
        return trace[-1]