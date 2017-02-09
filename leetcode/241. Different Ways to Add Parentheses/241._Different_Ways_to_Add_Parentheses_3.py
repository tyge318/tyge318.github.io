class Solution(object):
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        ans = []
        for index, i in enumerate(input):
            if i in ['+', '-', '*']:
                subans1 = self.diffWaysToCompute(input[:index])
                subans2 = self.diffWaysToCompute(input[index+1:])
                for j in subans1:
                    for k in subans2:
                        if i == '+':
                            ans.append(j+k)
                        elif i == '-':
                            ans.append(j-k)
                        else:
                            ans.append(j*k)
            
        if len(ans) == 0:
            ans.append(int(input))
        return ans