from collections import deque

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    '''
    方法 1
    递归
    '''

    def isSameTree1(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    '''
    方法 2
    循环
    '''

    def isSameTree2(self, p, q):
        def check(p, q):
            if not p and not q:
                return True
            if not p or not q:
                return False
            if p.val != q.val:
                return False
            return True

        dep = deque([(p, q), ])
        while dep:
            p, q = dep.popleft()
            if not check(p, q):
                return False

            if p:
                dep.append((p.left, q.left))
                dep.append((p.right, q.right))
        return True
