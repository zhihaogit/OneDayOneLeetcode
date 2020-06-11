'''
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0

        def recursion(root, sum):
            value = sum * 10 + root.val
            if not node.left and not node.right:
                return value
            leftValue = recursion(root.left, value) if root.left else 0
            rightValue = recursion(root.right, value) if root.right else 0
            return leftValue + rightValue
        return recursion(root, 0)
