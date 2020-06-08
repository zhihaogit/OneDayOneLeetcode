'''
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque


class Solution:
    # BFS广度优先算法
    def levelOrder1(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        deq = deque([root])
        res = []
        while deq:
            size = len(deq)
            val = []
            for i in range(size):
                node = deq.popleft()
                val.append(node.val)
                if node.left:
                    deq.append(node.left)
                if node.right:
                    deq.append(node.right)
            res.append(val)
        return res

    '''
    DFS深度优先也可以做
    记录每一层的 level,相同的 level的 node放到相同的数组里
    '''

    def levelOrder2(self, root: TreeNode) -> List[List[int]]:
        def recursion(root, level, res):
            if not root:
                return
            # 初始化当前 level的数组
            if len(res) == level:
                res.append([])
            res[level].append(root.val)
            if root.left:
                recursion(root.left, level + 1, res)
            if root.right:
                recursion(root.right, level + 1, res)
        result = []
        recursion(root, 0, result)
        return result
