class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        B = sum(min(secret.count(i), guess.count(i)) for i in "0123456789")
        A = 0
        for i in xrange(len(secret)):
            if secret[i] == guess[i]:
                A += 1
        B -= A
        return "%sA%sB" % (A, B)
        