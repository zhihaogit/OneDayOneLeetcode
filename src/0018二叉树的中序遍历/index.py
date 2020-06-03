'''
给定一个二叉树，返回它的中序 遍历。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        deq = deque([(1, root)])
        res = []
        while deq:
            s, node = deq.pop()
            if node is None:
                continue
            if s:
                deq.append((1, node.right))
                deq.append((0, node))
                deq.append((1, node.left))
            else:
                res.append(node.val)
        return res
