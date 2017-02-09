class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dict_st = {}
        dict_ts = {}
        for i in xrange(len(s)):
            if s[i] not in dict_st:
                dict_st[s[i]] = t[i]
            if t[i] not in dict_ts:
                dict_ts[t[i]] = s[i]
            if dict_st[s[i]] == t[i] and dict_ts[t[i]] == s[i]:
                continue
            else:
                return False
        return True