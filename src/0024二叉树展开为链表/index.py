'''
给定一个二叉树，原地将它展开为一个单链表。
例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        while root:
            if root.left:
                sub_left = root.left            # 找到 root的左子树
                while sub_left.right:           # 找到 左子树的最右的子树
                    sub_left = sub_left.right
                sub_left.right = root.right     # 将 root的右子树挂到最右的子树
                root.right = root.left          # 将 root的左子树挂到 root的右边
                root.left = None                # 清空左子树
            root = root.right                   # 继续节点操作
