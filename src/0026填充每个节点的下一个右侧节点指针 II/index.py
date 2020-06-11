'''
给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。

进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
'''

from collections import deque
'''
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
'''


class Solution:
    def connect1(self, root: 'Node') -> 'Node':
        if not root:
            return root
        deq = deque([root])
        while deq:
            size = len(deq)
            for i in range(size):
                node = deq.popleft()
                if i < size - 1:
                    node.next = deq[0]
                if node.left:
                    deq.append(node.left)
                if node.right:
                    deq.append(node.right)
        return root

    def connect2(self, root: 'Node') -> 'Node':
        if not root:
            return root

        def find(childNode, prev, leftmost):
            if childNode:
                if prev:
                    prev.next = childNode
                else:
                    leftmost = childNode
                prev = childNode
            return prev, leftmost

        leftmost = root
        while leftmost:
            prev, curr = None, leftmost
            leftmost = None
            while curr:
                prev, leftmost = find(curr.left, prev, leftmost)
                prev, leftmost = find(curr.right, prev, leftmost)
                curr = curr.next
        return root
