'''
给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。
学生出勤记录是只包含以下三个字符的字符串：
'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。

示例 1:
输入: n = 2
输出: 8 
解释：
有8个长度为2的记录将被视为可奖励：
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
只有"AA"不会被视为可奖励，因为缺勤次数超过一次。
注意：n 的值不会超过100000。
'''

import random


class Solution(object):
    # 方法1
    def checkRecord1(self, n):
        '''
        暴力输出
        递归找出所有的可能性
        再根据条件进行筛选
        '''
        condition = []

        def work(n, tmp):
            if n == 0:
                return condition.append(tmp)
            for t in ['A', 'L', 'P']:
                work(n-1, tmp + t)
        work(n, '')

        count = 0
        for t in condition:
            A_count = t.count('A')
            LLL_count = t.count('LLL')
            if A_count <= 1 and LLL_count == 0:
                count += 1
        return condition, count


if __name__ == '__main__':
    ins = Solution()
    final1 = ins.checkRecord1(2)
    print(final1)
