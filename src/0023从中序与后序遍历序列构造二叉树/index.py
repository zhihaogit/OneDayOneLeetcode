'''
根据一棵树的中序遍历与后序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        # 创建 val: index的 map，方便通过 val找到其所在的 index
        index_map = {ele: i for i, ele in enumerate(inorder)}

        def recursion(inorder_left, inorder_right):
            # 递归终止条件
            if inorder_left > inorder_right:
                return None
            # 从后序遍历的结果中取出当前的根节点
            val = postorder.pop()
            # 从中序遍历中找出当前 val的 index
            index = index_map[val]
            # 生成当前根节点
            root = TreeNode(val)
            # 先生成右树，在生成左树，符合后序遍历
            root.right = recursion(inorder_right, index - 1)
            root.left = recursion(index + 1, inorder_left)
            return root

        return recursion(0, len(inorder_left) - 1)
