'''
下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。

示例1:
 输入：num = 2（或者0b10）
 输出：[4, 1] 或者（[0b100, 0b1]）

示例2:
 输入：num = 1
 输出：[2, -1]

提示:
num的范围在[1, 2147483647]之间；
如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
'''

class Solution:
    def findClosedNumbers(self, num):
        '''
        较小数：找到 尽可能低位的 模式串'10' 翻转
        较大数：找到 尽可能低位的 模式串'01' 翻转
        若全为 1，不存在更小值，更大值则加一位1，第二位1变0
        '''
        st = str(bin(num))[2:]
        print(st)
        if st.count('0') == 0:
            return [int('0b10' + st[1:], 2), -1]
        st = '0' + st
        bigger, smaller = None, None
        # find smaller
        for i in range(len(st) - 1, -1, -1):
            if st[i: i + 2] == '10':
                tmp = st[i + 2:]
                tmp = '1' * tmp.count('1') + '0' * tmp.count('0')
                smaller = st[: i] + '01' + tmp
                break
        # find bigger
        for i in range(len(st) - 1, -1, -1):
            if st[i: i + 2] == '01':
                tmp = st[i + 2:]
                tmp = '0' * tmp.count('0') + '1' * tmp.count('1')
                bigger = st[: i] + '10' + tmp
                break
        return [int(bigger, 2), int(smaller, 2)]


if __name__ == '__main__':
    ins = Solution()
    final1 = ins.findClosedNumbers(20)
    print(final1, bin(final1[0]), bin(final1[1]))
