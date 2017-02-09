class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        current_max = 0
        exist_mark = []
        for i in xrange(len(words)):
            exist_mark.append( sum( 1 << (ord(x)-ord('a')) for x in set(words[i])) )
            
        for i in xrange(len(words)):
            for j in xrange(i, len(words)):
                if exist_mark[i] & exist_mark[j] == 0:
                    current_max = max(current_max, len(words[i])*len(words[j]) )
        return current_max