class Solution(object):
    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        dict = {}
        for i in xrange(60):
            key = bin(i).count('1')
            dict.setdefault(key, []).append(i)
        
        #print dict
        ans = []
        for i in xrange(num+1):
            j = num - i;
            if i > 5 or j > 5:
                continue
            hours = dict[i]
            minutes = dict[j]
            for hr in hours:
                if hr > 11:
                    continue
                for mn in minutes:
                    ans.append(str(hr)+':'+'{:>02}'.format(mn));
        return ans