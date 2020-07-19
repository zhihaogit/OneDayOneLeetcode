'''
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:
所有输入只包含小写字母 a-z 。
'''


class Solution:
    '''
    横向扫描
    '''

    def longestCommonPrefix1(self, strs: List[str]) -> str:
        if not strs:
            return ''

        def lcp(str1, str2):
            length, i = min(len(str1), len(str2)), 0
            while i < length and str1[i] == str2[i]:
                i += 1
            return str1[:i]

        prefix, count = strs[0], len(strs)
        for index in range(1, count):
            prefix = lcp(prefix, strs[index])
            if not prefix:
                break
        return prefix

    '''
    纵向扫描
    '''

    def longestCommonPrefix2(self, strs: List[str]) -> str:
        if not strs:
            return ''
        length, count = len(strs[0]), len(strs)
        for i in range(length):
            c = strs[0][i]
            if any(i == len(strs[j]) or c != strs[j][i] for j in range(1, count)):
                return strs[0][:i]
        return strs[0]

    '''
    分治算法
    '''

    def longestCommonPrefix3(self, strs: List[str]) -> str:
        if not strs:
            return ''

        def lcp(start, end):
            if start == end:
                return strs[start]
            mid = (start + end) // 2
            lcpLeft, lcpRight = lcp(start, mid), lcp(mid + 1, end)
            count = min(len(lcpLeft), len(lcpRight))
            for i in range(count):
                if lcpLeft[i] != lcpRight[i]:
                    return lcpLeft[:i]
            return lcpLeft[:count]
        return lcp(0, len(strs) - 1)

    '''
    二分查找
    '''

    def longestCommonPrefix4(self, strs: List[str]) -> str:
        if not strs:
            return ''

        def isCommonPrefix(length):
            str0, count = strs[0][:length], len(strs)
            return all(strs[j][:length] == str0 for j in range(1, count))

        minLength = min(len(s) for s in strs)
        low, high = 0, minLength
        while low < high:
            mid = (high - low + 1) // 2 + low
            if isCommonPrefix(mid):
                low = mid
            else:
                high = mid - 1
        return strs[0][:low]
