'''
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21

注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
'''


class Solution:
    # 字符串翻转
    def reverse(self, x: int) -> int:
        str_x = str(x)[::-1]

        if str_x.endswith('-'):
            str_x = '-' + str_x[:-1]
            return int(str_x) if int(str_x) >= -2**31 else 0
        return int(str_x) if int(str_x) <= 2**31 - 1 else 0
