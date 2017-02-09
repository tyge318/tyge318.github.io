class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        opt = []
        opt.append(triangle[0])
        for row, i in enumerate(triangle):
            if row == 0:
                continue
            rowOpt = []
            for col, j in enumerate(opt[-1]):
                if col == 0:
                    rowOpt.append(j+triangle[row][col] )
                else:
                    rowOpt[-1] = min(rowOpt[-1], j+triangle[row][col])
                rowOpt.append(j+triangle[row][col+1] )
            opt.append(rowOpt)
        print opt
        return min(opt[-1])