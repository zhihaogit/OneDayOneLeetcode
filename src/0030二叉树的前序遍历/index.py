'''
给定一个二叉树，返回它的 前序 遍历。
示例:
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 
输出: [1,2,3]
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        stack, output = [root], []
        while stack:
            node = stack.pop()
            output.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return output
