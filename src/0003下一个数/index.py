class Resolution:
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
    ins = Resolution()
    final1 = ins.findClosedNumbers(20)
    print(final1, bin(final1[0]), bin(final1[1]))
