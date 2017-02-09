class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        s += '+0'
        stack = []
        digitHolder = []
        undone = False
        for index, i in enumerate(s):
            if i.isdigit():
                digitHolder.append(i)
            else:
                if len(digitHolder) != 0:
                    temp = int(''.join(digitHolder))
                    if len(stack) >= 2 and (stack[-1] == '*' or stack[-1] == '/'):
                        op = stack.pop() #pop operator
                        operand = stack.pop() #pop operand
                        if op == '*':
                            temp = operand * temp
                        elif op == '/':
                            temp = operand / temp
                    stack.append(temp)
                    digitHolder = []
                if i == ' ':
                    continue
                else:
                    if i == '*' or i == '/':
                        stack.append(i)
                    else:   
                        if undone: #there exist previous '+' or '-'
                            b = stack.pop()
                            op = stack.pop()
                            a = stack.pop()
                            if op == '+':
                                stack.append(a+b)
                            elif op == '-':
                                stack.append(a-b)
                            #undone = False
                        else:   #first time of encountering '+' or '-'
                            undone = True
                        stack.append(i)
                    
        #print 'stack =', stack
        return stack[0]
        
        