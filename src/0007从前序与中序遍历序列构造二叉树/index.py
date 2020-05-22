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
        # 为 inorder生成哈希映射 value -> key的映射
        index = {ele: i for i, ele in enumerate(inorder)}
        def myBuildTree(preorder_left, preorder_right, inorder_left, inorder_right):
            # 设置 递归终止条件
            if preorder_left > preorder_right:
                return None
            # 拿到 前序里面根节点的位置
            preorder_root = preorder_left
            # 拿到 中序里面根节点的位置
            inorder_root = index[preorder[preorder_root]]
            # 生成 root的 nodeTree
            root = TreeNode(preorder[preorder_root])
            # 找到左子树的长度
            size_left_subtree = inorder_root - inorder_left
            # 递归地构造左子树，并连接到根节点
            # 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1)
            # 递归地构造右子树，并连接到根节点
            # 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right)
            return root

        n = len(preorder)
        return myBuildTree(0, n - 1, 0, n - 1)




if __name__ == '__main__':
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    ins = Solution()
    final1 = ins.buildTree(preorder, inorder)
    print (final1.val, final1.left, final1.right)
    
