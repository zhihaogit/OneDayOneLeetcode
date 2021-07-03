'''
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2

示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1

说明:
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
'''


class Solution:

    # 暴力解法 1
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        if n == 0:
            return 0
        for i in range(len(haystack) - n + 1):
            if haystack[i: i + n] == needle:
                return i
        return -1

    # 暴力解法 2
    def strStr1(self, haystack: str, needle: str) -> int:
        n = len(needle)
        if n == 0:
            return 0
        nf = needle[0]
        for i in range(len(haystack) - n + 1):
            if haystack[i] == nf:
                flag = True
                for j in range(n):
                    if haystack[i + j] != needle[j]:
                        flag = False
                        break
                if flag == True:
                    return i
        return -1

    # KMP算法
    def strStr2(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)
        if m == 0:
            return 0
        next = self.generateNext(needle)
        i = 0
        j = 0
        while i < n:
            while j > 0 and haystack[i] != needle[j]:
                j = next[j - 1]
            if haystack[i] == needle[j]:
                j += 1
            if j == m:
                return i - m + 1
            i += 1
        return -1

    def generateNext(self, needle):
        i = 1
        j = 0
        m = len(needle)
        next = [0] * m
        while i < m:
            while j > 0 and needle[i] != needle[j]:
                j = next[j - 1]
            if needle[i] == needle[j]:
                j += 1
            next[i] = j
            i += 1
        return next
