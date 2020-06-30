'''
二叉搜索树中的两个节点被错误地交换。
请在不改变其结构的情况下，恢复这棵树。

示例 1:
输入: [1,3,null,null,2]
   1
  /
 3
  \
   2
输出: [3,1,null,null,2]
   3
  /
 1
  \
   2

示例 2:
输入: [3,1,4,null,null,2]
  3
 / \
1   4
   /
  2
输出: [2,1,4,null,null,3]
  2
 / \
1   4
   /
  3

进阶:
使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    # 数组存储
    def recoverTree1(self, root: TreeNode) -> None:
        '''
        Do not return anything, modify root in-place instead.
        '''
        # 1. 中序遍历二叉树，使用一个数组进行存储
        nodes = []

        def recursion(root):
            if not root:
                return
            recursion(root.left)
            nodes.append(root)
            recursion(root.right)
        recursion(root)

        # 2. 遍历数组，找出可能存在错误交换的节点 x和 y
        x = y = None
        n = len(nodes)
        for i in range(n - 1):
            if nodes[i].val > nodes[i + 1].val:
                y = nodes[i + 1]
                if not x:
                    x = nodes[i]
                else:
                    break

        # 3. 如果 x和 y不为空，则交换两个节点值，恢复二叉搜索树
        if x and y:
            x.val, y.val = y.val, x.val

    # 指针存储
    def recoverTree2(self, root: TreeNode) -> None:
        self.x = self.y = self.pre = None

        def recursion(root):
            if not root:
                return
            recursion(root.left)
            if not self.pre:
                self.pre = root
            else:
                if self.pre.val > root.val:
                    self.y = root
                    if not self.x:
                        self.x = self.pre
                self.pre = root
            recursion(root.right)

        recursion(root)

        if self.x and self.y:
            self.x.val, self.y.val = self.y.val, self.x.val
