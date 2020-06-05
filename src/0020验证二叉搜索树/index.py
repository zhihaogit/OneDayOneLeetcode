'''
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
  节点的左子树只包含小于当前节点的数。
  节点的右子树只包含大于当前节点的数。
  所有左子树和右子树自身必须也是二叉搜索树。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def isValidBST1(self, root: TreeNode) -> bool:
        def recursion(left, root, right):
            if not root:
                return True
            val = root.val
            if val <= left or val >= right:
                return False
            if not recursion(left, root.left, val):
                return False
            if not recursion(val, root.right, right):
                return False
            return True
        return recursion(float('-inf'), root, float('inf'))

    '''
    中序遍历
    '''

    def isValidBST2(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack, inorder = [], float('-inf')
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= inorder:
                return False
            inorder = root.val
            root = root.right
        return True
