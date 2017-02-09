class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) == 0:
            return None
        if len(s) == 1:
            return s
        ans = s[0:1]
        for i in xrange(len(s)):
            temp = self.getPalindrome(s, i, i)
            if len(temp) > len(ans):
                ans = temp
            temp = self.getPalindrome(s, i, i+1)
            if len(temp) > len(ans):
                ans = temp
        return ans
            
    def getPalindrome(self, s, begin, end):
        while begin >= 0 and end < len(s) and s[begin] == s[end]:
            begin -= 1
            end += 1
        return s[begin+1:end]
        