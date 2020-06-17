'''
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Solution:
    # DFS
    def rightSideView1(self, root: TreeNode) -> List[int]:
        rightmost_val_at_depth = dict()
        max_depth = -1

        stack = [(root, 0)]
        while stack:
            node, depth = stack.pop()
            if node:
                max_depth = max(max_depth, depth)
                rightmost_val_at_depth.setdefault(depth, node.val)
                stack.append((node.left, depth + 1))
                stack.append((node.right, depth + 1))
        return [rightmost_val_at_depth[depth] for depth in range(max_depth + 1)]

    #BFS
    def rightSideView2(self, root: TreeNode) -> List[int]:
        rightmost_val_at_depth = dict()
        max_depth = -1

        stack = deque([(root, 0)])
        while stack:
            node, depth = stack.popleft()
            if node:
                max_depth = max(max_depth, depth)
                rightmost_val_at_depth[depth] = node.val
                stack.append((node.left, depth + 1))
                stack.append((node.right, depth + 1))
        return [rightmost_val_at_depth[depth] for depth in range(max_depth + 1)]
