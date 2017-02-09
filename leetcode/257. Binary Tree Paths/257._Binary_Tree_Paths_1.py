# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        self.paths = []
        self.DFS(root, None)
        #print self.paths
        return self.paths
     
    def DFS(self, current, path):
        if not current:
            return
        if not path:
            path = str(current.val)
        else:
            path += ('->' + str(current.val) )
        if not current.left and not current.right:
            self.paths.append(path)
        else:
            if current.left:
                self.DFS(current.left, path)
            if current.right:
                self.DFS(current.right, path)
    