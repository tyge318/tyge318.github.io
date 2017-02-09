import heapq
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        freqs = {}
        for i in nums:
            if i not in freqs:
                freqs[i] = 1
            else:
                freqs[i] += 1
        
        tuples = freqs.items()
        temp = heapq.nlargest(k, tuples, key=lambda i: i[1])
        return [i[0] for i in temp]
        
        
        