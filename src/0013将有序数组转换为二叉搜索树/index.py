'''
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
'''
from random import randint
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        def cursion(leftIndex, rightIndex):
            if leftIndex > rightIndex:
                return None
            # 整除得到中间的 index，来当做根节点
            middleIndex = (leftIndex + rightIndex) // 2
            # 通过加0|1的方式随机取出中间左侧或者右侧来当做中间节点，这一步可加可不加
            if (leftIndex + rightIndex) % 2:
                middleIndex += randint(0, 1)
            root = TreeNode(nums[middleIndex])
            root.left = cursion(leftIndex, middleIndex - 1)
            root.right = cursion(middleIndex + 1, rightIndex)
            return root
        return cursion(0, len(nums) - 1)
