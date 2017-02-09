class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        opt = [0]*(amount+1)
        for i in xrange(1, amount+1):
            if i in coins:
                opt[i] = 1
                continue
            #opt[i] = min([opt[min(0, i-j)]+1 for j in coins])
            temp = []
            for j in coins:
                if i-j < 0 or opt[i-j] == -1:
                    continue
                temp.append(opt[i-j]+1)
            opt[i] = -1 if len(temp) == 0 else min(temp)
        #print opt
        return (opt[amount] if opt[amount] != (amount+1) else -1)