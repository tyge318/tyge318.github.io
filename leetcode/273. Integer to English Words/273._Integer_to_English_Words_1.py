class Solution(object):
    map = {}
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        self.buildMap()
        ans = self.convert(num)
        #print ans
        return ans
        
    def convert(self, n):
        if n <= 20:
            return self.map[n]
        if 20 < n <= 99:
            if n % 10 == 0:
                return self.map[n/10*10];
            return self.map[n/10*10]+' '+self.convert(n%10)
        if 100 <= n <= 999:
            if n % 100 == 0:
                return self.convert(n/100) + ' Hundred'
            return self.convert(n/100) + ' Hundred ' +self.convert(n%100)
        if 1000 <= n <= 999999:
            if n % 1000 == 0:
                return self.convert(n/1000) + ' Thousand'
            return self.convert(n/1000) + ' Thousand ' + self.convert(n%1000)
        if 1000000 <= n <= 999999999:
            if n % 1000000 == 0:
                return self.convert(n/1000000) + ' Million'
            return self.convert(n/1000000) + ' Million ' + self.convert(n%1000000)
        if 1000000000 <= n <= 999999999999:
            if n % 1000000000 == 0:
                return self.convert(n/1000000000) + ' Billion'
            return self.convert(n/1000000000) + ' Billion ' + self.convert(n%1000000000)
        
    def buildMap(self):
        self.map[0] = "Zero"
        self.map[1] = "One"
        self.map[2] = "Two"
        self.map[3] = "Three"
        self.map[4] = "Four"
        self.map[5] = "Five"
        self.map[6] = "Six"
        self.map[7] = "Seven"
        self.map[8] = "Eight"
        self.map[9] = "Nine"
        self.map[10] = "Ten"
        self.map[11] = "Eleven"
        self.map[12] = "Twelve"
        self.map[13] = "Thirteen"
        self.map[14] = "Fourteen"
        self.map[15] = "Fifteen"
        self.map[16] = "Sixteen"
        self.map[17] = "Seventeen"
        self.map[18] = "Eighteen"
        self.map[19] = "Nineteen"
        self.map[20] = "Twenty"
        self.map[30] = "Thirty"
        self.map[40] = "Forty"
        self.map[50] = "Fifty"
        self.map[60] = "Sixty"
        self.map[70] = "Seventy"
        self.map[80] = "Eighty"
        self.map[90] = "Ninety"