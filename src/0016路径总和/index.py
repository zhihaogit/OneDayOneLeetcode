'''
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

返回值：布尔值
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def hasPathSum1(self, root: TreeNode, sum: int) -> bool:
        def recursion(root, acc, sum):
            if not root:
                return False
            acc += root.val
            if not root.left and not root.right:  # 叶子节点
                return acc == sum
            return recursion(root.left, acc, sum) or recursion(root.right, acc, sum)
        return recursion(root, 0, sum)

    def hasPathSum2(self, root: TreeNode, sum: int) -> bool:
        def recursion(root, sum):
            if not root:
                return False
            sum -= root.val
            if not root.left and not root.right:  # 叶子节点
                return 0 == sum
            return recursion(root.left, sum) or recursion(root.right, sum)
        return recursion(root, sum)

    def hasPathSum3(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        deq = deque([(root, sum - root.val)])
        while deq:
            node, acc = deq.popleft()
            if not node.left and not node.right and acc == 0:
                return True
            if node.left:
                deq.append((node.left, acc - node.left.val))
            if node.right:
                deq.append((node.right, acc - node.right.val))
        return False

    def hasPathSum4(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        deq = deque([(root, 0 + root.val)])
        while deq:
            node, acc = deq.popleft()
            if not node.left and not node.right and acc == sum:
                return True
            if node.left:
                deq.append((node.left, acc + node.left.val))
            if node.right:
                deq.append((node.right, acc + node.right.val))
        return False
