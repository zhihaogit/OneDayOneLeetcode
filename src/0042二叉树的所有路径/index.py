'''
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。

示例:
输入:
   1
 /   \
2     3
 \
  5
输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def binaryTreePaths1(self, root: TreeNode) -> List[str]:
        if not root:
            return []

        def recursion(root, path):
            if not root.left and root.right:
                paths.append(path)
            if root.left:
                recursion(root.left, path + '->' + str(root.left.val))
            if root.right:
                recursion(root.right, path + '->' + str(root.right.val))
        paths = []
        recursion(root, str(root.val))
        return paths

    def binaryTreePaths2(self, root: TreeNode) -> List[str]:
        if not root:
            return []
        stack = [(root, str(root.val))]
        paths = []
        while stack:
            node, path = stack.pop()
            if not node.left and not node.right:
                paths.append(path)
            if node.left:
                stack.append((node.left, str(node.left.val)))
            if node.right:
                stack.append((node.right, str(node.right.val)))
        return paths
