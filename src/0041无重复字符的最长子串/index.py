'''
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
'''


class Solution:
    # def lengthOfLongestSubstring(self, s: str) -> int:
    def lengthOfLongestSubstring(self, s):
        # oc set数据用于存储不重复的字符
        oc = set()
        # rk 右指针指向 -1，即字串的最左边
        # maxLength 不重复字段的最大长度
        # sLength 字符串当前的长度
        rk, maxLength = -1, 0
        sLength = len(s)
        for lk in range(sLength):
            # 遍历字符串，左指针每次加一之后，set数据移除一个字符
            if lk != 0:
                oc.remove(s[lk - 1])
            # 右指针向右移动，如果没有 set中没出现当前字符，就加入进来
            while rk < sLength - 1 and s[rk + 1] not in oc:
                oc.add(s[rk + 1])
                rk += 1
            # rk - lk + 1为当前不重复字符串的长度
            # 每次都取出不重复字符的最大长度
            maxLength = max(maxLength, rk - lk + 1)
        return maxLength


if __name__ == '__main__':
    string = 'pwwkew'
    ins = Solution()
    print(ins.lengthOfLongestSubstring(string))
