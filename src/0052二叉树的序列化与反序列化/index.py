'''
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

示例: 
你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5
序列化为 "[1,2,3,null,null,4,5]"
提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
'''

from collections import deque

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Codec:

    '''
    dfs
    前序遍历进行序列化
    '''

    def serializeDfs(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        def recursion(root):
            if not root:
                return 'X,'
            leftSerialized = recursion(root.left)
            rightSerialized = recursion(root.right)
            return str(root.val) + ',' + leftSerialized + rightSerialized
        return recursion(root)

    def deserializeDfs(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        list = data.split(',')

        def recursion(l):
            val = l.pop(0)
            if val == 'X':
                return None
            node = TreeNode(val)
            node.left = recursion(l)
            node.right = recursion(l)
            return node
        return recursion(list)

    '''
    BFS
    '''

    def serializeBfs(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return None
        q = deque([root])
        res = []
        while q:
            node = q.popleft()
            if node:
                res.append(str(node.val))
                q.append(node.left)
                q.append(node.right)
            else:
                res.append('null')
        return ','.join(res)

    def deserializeBfs(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        vals, i = data.split(','), 1
        root = TreeNode(vals[0])
        q = deque([root])
        while q:
            node = q.popleft()
            if vals[i] != 'null':
                node.left = TreeNode(int(vals[i]))
                q.append(node.left)
            i += 1
            if vals[i] != 'null':
                node.right = TreeNode(int(vals[i]))
                q.append(node.right)
            i += 1
        return root


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
