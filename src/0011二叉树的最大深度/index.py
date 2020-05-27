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
