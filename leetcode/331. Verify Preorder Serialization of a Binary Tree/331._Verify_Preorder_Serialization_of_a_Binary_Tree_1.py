class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        stack = []
        for i in preorder.split(','):
            stack.append(i)
            while len(stack) >= 3 and (stack[-1] == stack[-2] == '#') and (stack[-3] != '#'):
                stack.pop()
                stack.pop()
                stack.pop()
                stack.append('#')
        if len(stack) == 1 and stack[0] == '#':
            return True
        else:
            return False