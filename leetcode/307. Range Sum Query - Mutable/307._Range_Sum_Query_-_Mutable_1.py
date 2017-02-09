class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.btree = [0 for i in xrange(len(nums)+1)]
        self.nums = nums
        
        for i in xrange(len(nums)):
            self.add(i+1, nums[i])
        
    def add(self, i, val):
        j = i;
        while j < len(self.btree):
            self.btree[j] += val
            j += (j & -j)

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: int
        """
        self.add(i+1, val-self.nums[i])
        self.nums[i] = val
    
    def btreeSum(self, i):
        sum = 0
        j = i
        while j > 0:
            sum += self.btree[j]
            j -= (j & -j)
        return sum

    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.btreeSum(j+1)-self.btreeSum(i)
        


# Your NumArray object will be instantiated and called as such:
# numArray = NumArray(nums)
# numArray.sumRange(0, 1)
# numArray.update(1, 10)
# numArray.sumRange(1, 2)