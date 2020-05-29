'''
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
'''
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def levelOrderBottom1(self, root: TreeNode) -> List[List[int]]:
        result = []

        def recusion(root, depth):
            if not root:
                return
            if len(result) == depth:
                result.insert(0, [])
            result[-(depth + 1)].append(root.val)
            recusion(root.left, depth + 1)
            recusion(root.right, depth + 1)
        recusion(root, 0)
        return result

    def levelOrderBottom1(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        result = []
        deq = deque([root])
        while deq:
            tmp = []
            for i in range(len(deq)):
                node = deq.popleft()
                if node:
                    tmp.append(node.val)
                if node.left:
                    deq.append(node.left)
                if node.right:
                    deq.append(node.right)
            result.insert(0, tmp)
        return result
