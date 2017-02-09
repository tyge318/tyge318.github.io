class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.total = capacity
        self.cache = collections.OrderedDict()

    def get(self, key):
        """
        :rtype: int
        """
        if not self.cache.has_key(key):
            return -1
        value = self.cache.pop(key)
        self.cache[key] = value
        return value
            
    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if self.cache.has_key(key):
            self.cache.pop(key)
        elif len(self.cache) == self.total:
            self.cache.popitem(last = False)
        self.cache[key] = value
        