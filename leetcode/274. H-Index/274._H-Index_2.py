class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        citations.sort()
        citations.reverse()
        #print citations
        for index, i in enumerate(citations):
            if i >= index+1:
                if (index+1 < len(citations) and citations[index+1] < index+2) or index+1 == len(citations):
                    return index+1
        return 0