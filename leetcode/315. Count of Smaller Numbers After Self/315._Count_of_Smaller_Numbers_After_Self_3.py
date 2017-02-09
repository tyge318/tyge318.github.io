class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        indices = {}
        for index, value in enumerate(sorted(set(nums))):
            indices[value] = index+1
        converted = [indices[i] for i in nums]
        #print 'original list = ', nums
        #print 'converted list = ', converted
        btree = BIT(len(nums))
        ans = [0]*len(nums)
        for i in xrange(len(ans)-1, -1, -1):    #right to left
            #print 'btree = ', btree.btree
            ans[i] = btree.sum(converted[i]-1)
            #print 'ans[', i, ']=', ans[i]
            btree.insert(converted[i], 1)
        return ans
        
class BIT(object):
    def __init__(self, n):
        self.n = n;
        self.btree = [0]*(n+1)
    
    def insert(self, i, value):
        #print 'insert "', value, '" to position "', i, '"'
        while i <= self.n:
            self.btree[i] += value
            i += (i & -i)
    
    def sum(self, i):
        sum = 0
        while i > 0:
            sum += self.btree[i]
            i -= (i & -i)
        return sum