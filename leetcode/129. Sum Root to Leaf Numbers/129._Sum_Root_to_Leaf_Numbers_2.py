from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        vals = {}
        q = deque([root])
        vals[root] = root.val
        ans = 0
        while len(q) > 0:
            cur = q.popleft()
            left = cur.left
            if left:
                vals[left] = 10*vals[cur]+left.val
                q.append(left)
            right = cur.right
            if right:
                vals[right] = 10*vals[cur]+right.val            
                q.append(right)
            if not left and not right: #leaf
                ans += vals[cur]
        return ans
        