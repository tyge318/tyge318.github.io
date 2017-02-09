class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        tokens = str.split()
        return (map(pattern.index, pattern) == map(tokens.index, tokens))