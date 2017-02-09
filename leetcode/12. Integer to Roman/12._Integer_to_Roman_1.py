class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        dict = {1000: "M", 900: "CM", 500: "D", 400: "CD", 100: "C", 90: "XC", 50: "L", 40: "XL", 10: "X", 9: "IX", 5: "V", 4: "IV", 1: "I"}
        roman = []
        for key in sorted(dict.keys(), reverse=True):
            if num >= key:
                repeat = num / key
                num = num % key
                for i in xrange(repeat):
                    roman.append(dict[key])
        return ''.join(roman)