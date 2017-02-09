class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        unit = {"M": 1000, "D": 500, "C": 100, "L": 50, "X": 10, "V": 5, "I": 1}
        compound = {"CM": 900, "CD": 400, "XC": 90, "XL": 40, "IX": 9, "IV": 4}
        ans = 0
        skipNext = False
        for i, cs in enumerate(s):
            if skipNext:
                skipNext = False
                continue
            if s[i:i+2] in compound:
                skipNext = True
                ans += compound[s[i:i+2]]
                continue
            elif cs in unit:
                ans += unit[cs]
        return ans
                