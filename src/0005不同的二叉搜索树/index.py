'''
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
'''
class Solution:
    # 方法1
    def numTrees1(self, n):
        '''
        动态规划
        '''
        G = [0] * (n + 1)
        G[0], G[1] = 1, 1
        for i in range(2, n + 1):
            for j in range(1, i + 1):
                G[i] += G[j - 1] * G[i - j]
        return G[n]

    # 方法2
    def numTrees2(self, n):
        '''
        G(n)函数的值被称为 卡塔兰数 C n
        '''
        C = 1
        for i in range(0, n):
            C = C * 2 * (2 * i + 1) / (i + 2)
        return int(C)


if __name__ == '__main__':
    n = 5
    ins = Solution()
    final1 = ins.numTrees1(n)
    final2 = ins.numTrees2(n)
    print(final1, final2)
