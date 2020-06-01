'''
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        leftMin = self.minDepth(root.left)
        rightMin = self.minDepth(root.right)
        finalMin = min(leftMin, rightMin) if leftMin and rightMin else leftMin or rightMin
        return finalMin + 1