'''
根据一棵树的前序遍历与中序遍历构造二叉树
你可以假设树中没有重复的元素
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
生成：
    3
   / \
  9  20
    /  \
   15   7
'''


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder, inorder):


if __name__ == '__main__':
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    ins = Solution()
    final1 = ins.buildTree(preorder, inorder)
    # final2 = ins.numTrees2(n)
    print(final1)
