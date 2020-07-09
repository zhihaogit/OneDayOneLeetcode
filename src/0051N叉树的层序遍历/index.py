'''
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :
返回其层序遍历:
[
  [1],
  [3,2,4],
  [5,6]
]

说明:
树的深度不会超过 1000。
树的节点总数不会超过 5000。
'''


"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""




from collections import deque
class Solution:
    def levelOrder1(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        result = []
        deq = deque([root])
        while deq:
            level = []
            for _ in range(len(deq)):
                node = deq.popleft()
                level.append(node.val)
                deq.extend(node.children)
            result.append(level)
        return result

    def levelOrder2(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        result = []
        previous_layer = [root]
        while previous_layer:
            current_layer = []
            result.append([])
            for node in previous_layer:
                result[-1].append(node.val)
                current_layer.extend(node.children)
            previous_layer = current_layer
        return result

    def levelOrder3(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        result = []

        def recursion(root, level):
            if len(result) == level:
                result.append([])
            result[level].append(root.val)
            for child in root.children:
                recursion(child, level + 1)

        recursion(root, 0)
        return result
