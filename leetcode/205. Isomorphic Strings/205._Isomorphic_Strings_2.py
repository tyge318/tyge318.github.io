class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        map1 = {}
        map2 = {}
        for index, i in enumerate(s):
            if i not in map1 and t[index] not in map2:
                map1[i] = t[index]
                map2[t[index]] = i
            elif i in map1 and t[index] in map2:
                if map1[i] == t[index] and map2[t[index]] == i:
                    continue
                else:
                    return False
            else:
                return False
        return True