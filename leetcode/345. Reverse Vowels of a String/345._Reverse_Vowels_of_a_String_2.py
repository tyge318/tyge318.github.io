class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = []
        vowels_pos = []
        for index, i in enumerate(s):
            if i.lower() in ['a', 'e', 'i', 'o', 'u']:
                vowels.append(i)
                vowels_pos.append(index)
        vowels_pos.reverse()
        letters = list(s)
        for i in xrange(len(vowels)):
            letters[vowels_pos[i]] = vowels[i]
        
        return ''.join(letters)
            