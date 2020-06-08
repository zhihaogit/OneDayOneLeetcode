'''
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque


class Solution:
    def zigzagLevelOrder1(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        res = []
        deq = deque([root])
        count = 0
        while deq:
            vals = []
            size = len(deq)
            count += 1
            reverse_flag = count % 2
            for i in range(size):
                node = deq.popleft()
                vals.append(node.val) if reverse_flag else vals.insert(
                    0, node.val)
                if node.left:
                    deq.append(node.left)
                if node.right:
                    deq.append(node.right)
            res.append(vals)
        return res

    def zigzagLevelOrder2(self, root: TreeNode) -> List[List[int]]:
        def recursion(root, level, res):
            if not root:
                return
            if len(res) == level:
                res.append([])
            res[level].insert(
                0, root.val) if level % 2 else res[level].append(root.val)
            if root.left:
                recursion(root.left, level + 1, res)
            if root.right:
                recursion(root.right, level + 1, res)
        res = []
        recursion(root, 0, res)
        return res
