'''
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    '''
    方法1
    递归
    '''

    def maxDepth1(self, root: TreeNode) -> int:
        return 0 if not root else max(self.maxDepth1(root.left), self.maxDepth1(root.right)) + 1

    '''
    方法2
    迭代
    '''

    def maxDepth2(self, root: TreeNode) -> int:
        stack = []
        if root:
            stack.append((1, root))

        dept = 0
        while len(stack):
            current_dept, current_root = stack.pop()
            if current_root:
                dept = max(dept, current_dept)
                stack.append((current_dept + 1, current_root.left))
                stack.append((current_dept + 1, current_root.right))
        return dept
