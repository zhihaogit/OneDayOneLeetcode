'''
计算给定二叉树的所有左叶子之和。

示例：
    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def sumOfLeftLeaves1(self, root: TreeNode) -> int:
        if not root:
            return 0

        self.sum = 0

        def recursion(root, isLeft):
            if not root:
                return
            if isLeft and not root.left and not root.right:
                self.sum += root.val
            else:
                recursion(root.left, True)
                recursion(root.right, False)
        recursion(root, False)
        return self.sum

    def sumOfLeftLeaves2(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.sum = 0
        stack = [(root, False)]
        while stack:
            node, isLeft = stack.pop()
            if isLeft and not node.left and not node.right:
                self.sum += node.val
            else:
                if node.left:
                    stack.append((node.left, True))
                if node.right:
                    stack.append((node.right, False))
        return self.sum
