import random


class Resolution(object):
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
    ins = Resolution()
    final1 = ins.checkRecord1(2)
    print(final1)
