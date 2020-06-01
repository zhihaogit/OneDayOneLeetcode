'''
给定一个二叉树，判断它是否是高度平衡的二叉树。
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    '''
    方法1：
    自顶向下递归，找到每个节点左右两边的高度差，再判断是否平衡
    每次都会找一次高度，会有冗余查找
    '''

    def height(self, root):
        if not root:
            return -1
        return 1 + max(self.height(root.left), self.height(root.right))

    def isBalanced1(self, root: TreeNode) -> bool:
        if not root:
            return True
        return abs(self.height(root.left) - self.height(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)

    '''
    方法2：
    自底向上递归，先判断是否平衡，节点的高度计算只会一次
    检查子树是否平衡。如果平衡，则使用它们的高度判断父节点是否平衡，并计算父节点的高度。
    '''

    def isBalancedHelper(self, root):
        if not root:
            return True, -1
        isLeftBalanced, leftHeight = self.isBalancedHelper(root.left)
        if not isLeftBalanced:
            return False, 0
        isRightBalanced, rightHeight = self.isBalancedHelper(root.right)
        if not isRightBalanced:
            return False, 0

        # 平衡条件
        return abs(leftHeight - rightHeight) < 2, 1 + max(leftHeight, rightHeight)

    def isBalanced2(self, root: TreeNode) -> bool:
        return self.isBalancedHelper(root)[0]
