'''
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

复习一下二叉搜索树（BST）的性质：
1. 节点 NN 左子树上的所有节点的值都小于等于节点 NN 的值
2. 节点 NN 右子树上的所有节点的值都大于等于节点 NN 的值
3. 左子树和右子树也都是 BST

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

示例 1:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。

示例 2:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。

说明:
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    '''
    1. 从根节点开始遍历树
    2. 如果节点 p, q都在右子树，以右子树为根节点执行步骤1
    3. 如果节点 p, q都在左子树，以左子树为根节点执行步骤1
    4. 以上 2, 3不成立，即是公共祖先
    '''

    def lowestCommonAncestor1(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent_val = root.val
        p_val = p.val
        q_val = q.val
        if p_val > parent_val and q_val > parent_val:
            return self.lowestCommonAncestor1(root.right, p, q)
        elif p_val < parent_val and q_val < parent_val:
            return self.lowestCommonAncestor1(root.left, p, q)
        else:
            return root

    def lowestCommonAncestor2(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        p_val = p.val
        q_val = q.val
        node = root
        while node:
            parent_val = node.val
            if p_val > parent_val and q_val > parent_val:
                node = node.right
            elif p_val < parent_val and q_val < parent_val:
                node = node.left
            else:
                return node
