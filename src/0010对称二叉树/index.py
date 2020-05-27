'''
给定一个二叉树，检查它是否是镜像对称的
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    '''
    方法1，递归
    '''

    def isSymmetric1(self, root: TreeNode) -> bool:
        if not root:
            return True

        def recursionFind(l, r):
            if not l and not r:
                return True
            if not l or not r:
                return False
            if l.val != r.val:
                return False
            return recursionFind(l.left, r.right) and recursionFind(r.left, l.right)
        return recursionFind(root.left, root.right)

    '''
    方法2，迭代
    '''

    def isSymmetric2(self, root: TreeNode) -> bool:
        if not root:
            return True

        def check(l, r):
            if not l and not r:
                return True
            if not l or not r:
                return False
            if l.val != r.val:
                return False
            return True

        deq = deque([(root.left, root.right), ])

        while deq:
            l, r = deq.popleft()
            if not check(l, r):
                return False
            if l:
                deq.append((l.left, r.right))
                deq.append((r.left, l.right))
        return True
