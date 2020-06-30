'''
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:
输入: [1,2,3]
    1
  / \
  2   3
输出: 6

示例 2:
输入: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7
输出: 42
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def __init__(self):
        self.maxSum = float('-inf')

    def maxPathSum(self, root: TreeNode) -> int:
        def maxGain(root):
            if not root:
                return 0
            # 递归计算左右子节点的最大贡献值
            # 只有在最大贡献值大于 0 时，才会选取对应子节点
            leftGain = max(maxGain(root.left), 0)
            rightGain = max(maxGain(root.right), 0)
            # 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            priceNewPath = root.val + leftGain + rightGain
            # 更新最大值
            self.maxSum = max(self.maxSum, priceNewPath)
            # 返回该节点的最大贡献值
            return root.val + max(leftGain, rightGain)

        maxGain(root)
        return self.maxSum
