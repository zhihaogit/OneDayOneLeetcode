'''
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例 1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例 2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2 

提示：
被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
'''


class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        sign = 1  # 记录是负数还是正数，根据情况将所有负数转为正数进行运算
        if dividend > 0 and divisor < 0:
            sign = -1
            divisor = -divisor
        elif dividend < 0 and divisor > 0:
            sign = -1
            dividend = -dividend
        elif dividend < 0 and divisor < 0:
            dividend = -dividend
            divisor = -divisor

        remain = dividend  # 余数
        result = 0  # 商
        while remain >= divisor:  # 如果余数比除数更大或相等，进入循环
            cur = 1  # 倍增商
            div = divisor  # 倍增值
            while div + div < remain:  # 倍增值相加仍比余数小，进入循环
                cur += cur  # 倍增商自增
                div += div  # 倍增值自增
            remain -= div  # 余数减去倍增值
            result += cur  # 商加上倍增商

        if sign < 0:
            result = -result

        if result >= 2 ** 31:  # 按照题目要求，溢出处理
            result = 2 ** 31 - 1

        return result
