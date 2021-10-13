'''
给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        def recursion(left, right):
            if left > right:
                return [None,]
            all_tree = []
            # 随机取一个值 i为 root
            for i in range(left, right + 1):
                # 当 i为 root时，取到的所有 left节点
                left_tree = recursion(left, i - 1)
                # 当 i为 root时，取到的所有 right节点
                right_tree = recursion(i + 1, right)

                # 根据左右子树的笛卡尔积，找到所有可能的树
                for l in left_tree:
                    for r in right_tree:
                        root = TreeNode(i)
                        root.left = l
                        root.right = r
                        all_tree.append(root)
            return all_tree
        return recursion(1, n) if n else []
