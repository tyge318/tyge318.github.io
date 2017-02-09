# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans = []
        currentLevel = []
        nextLevel = []
        if root:
            currentLevel.append(root)
        while len(currentLevel) != 0:
            for index, i in enumerate(currentLevel):
                if i.left:
                    nextLevel.append(i.left)
                if i.right:
                    nextLevel.append(i.right)
                if index == len(currentLevel)-1:
                    ans.append(i.val)
            currentLevel[:] = []
            currentLevel = nextLevel
            nextLevel = []
        return ans