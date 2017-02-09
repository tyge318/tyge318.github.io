class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
        stack = []
        digitHolder = []
        for index, c in enumerate(s):
            if not c.isdigit():
                if len(digitHolder) != 0:
                    stack.append(int(''.join(digitHolder)))
                    digitHolder = []
                if c == ' ':
                    continue
                if c == '(' or c == '+' or c == '-':
                    stack.append(c)
                    #print 'statck = ', stack
                    continue
                if c == ')':
                    #print '@stack = ', stack
                    begin = None
                    for j in xrange(len(stack)-1, -1, -1):
                        if stack[j] == '(':
                            begin = j
                            break
                    #print 'begin = ', begin
                    tempAns = stack[begin+1]
                    op = None
                    for j in xrange(begin+2, len(stack)):
                        if stack[j] == '+' or stack[j] == '-':
                            op = stack[j]
                        else:
                            if op == '+':
                                tempAns += stack[j]
                            elif op == '-':
                                tempAns -= stack[j]
                    stack = stack[:begin]
                    stack.append(tempAns)
            else:
                digitHolder.append(c)
        if len(digitHolder) != 0:
            stack.append(int(''.join(digitHolder)))
            digitHolder = []

        if len(stack) == 1:
            return stack.pop()
        else:
            #print '#stack = ', stack
            ans = stack[0]
            op = None
            for j in xrange(1, len(stack)):
                if stack[j] == '+' or stack[j] == '-':
                    op = stack[j]
                else:
                    if op == '+':
                        ans += stack[j]
                    else:
                        ans -= stack[j]
            return ans