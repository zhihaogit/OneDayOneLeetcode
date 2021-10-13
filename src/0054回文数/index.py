'''
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:
你能不将整数转为字符串来解决这个问题吗？
'''

from collections import deque

class Solution:
    # 将 int转换为 str类型，双向队列
    def isPalindrome1(self, x: int) -> bool:
        lst = deque(str(x))
        while len(lst) > 1:
            if lst.popleft() != lst.pop():
                return False
        return True

    # 双指针
    def isPalindrome2(self, x: int) -> bool:
        lst = list(str(x))
        l, r = 0, len(lst) - 1
        while l <= r:
            if lst[l] != lst[r]:
                return False
            l += 1
            r -= 1
        return True

    # 翻转最后一半的数字，与前一半进行比较
    def isPalindrome3(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        reversedNumber = 0
        while x > reversedNumber:
            reversedNumber = reversedNumber * 10 + x % 10
            x = x // 10
        return x == reversedNumber or x == reversedNumber // 10
