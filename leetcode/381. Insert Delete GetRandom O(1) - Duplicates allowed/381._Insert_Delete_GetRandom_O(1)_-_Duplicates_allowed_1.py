import random
class RandomizedCollection(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # self.indices => map value to index (could be many)
        self.indices = collections.defaultdict(set)
        
        # self.data => list containing all element
        self.data = []

    def insert(self, val):
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        ans = val not in self.indices
        #len(self.data) will be the index for the inserted val
        self.indices[val].add(len(self.data))
        self.data.append(val)
        return ans

    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.indices:
            return False
        #get the vary last one, if it's the target, then remove it; otherwise, move it to where target currently is.
        last = self.data.pop()
        self.indices[last].remove(len(self.data))
        
        if val != last:
            targetIndex = self.indices[val].pop()
            self.indices[last].add(targetIndex)
            self.data[targetIndex] = last
        
        if len(self.indices[val]) == 0:
            del self.indices[val]
        return True

    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        return self.data[random.randint(0, len(self.data)-1) ]


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()