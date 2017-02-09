class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        m = len(s)+1
        n = len(p)+1
        opt = [[False for i in xrange(n)] for j in xrange(m)]
        
        opt[0][0] = True
        for i in xrange(m):
            for j in xrange(1, n):
                if p[j-1] != '.' and p[j-1] != '*':
                    if i>0 and s[i-1]==p[j-1] and opt[i-1][j-1]:
                        opt[i][j] = True
                elif p[j-1] == '.':
                    if i>0 and opt[i-1][j-1]:
                        opt[i][j] = True
                elif j>1:   # cannot be the 1st element
                    if opt[i][j-1] or opt[i][j-2]:  # match 0 or 1 preceding element
                        opt[i][j] = True
                    elif i>0 and (p[j-2]==s[i-1] or p[j-2]=='.') and opt[i-1][j]: #match multiple preceding elements
                        opt[i][j] = True
                    
        return opt[m-1][n-1]
                        