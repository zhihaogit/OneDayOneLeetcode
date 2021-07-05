'''
给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。

示例 1：
输入：s = "barfoothefoobarman", words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
输出：[]

示例 3：
输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
输出：[6,9,12]

提示：
1 <= s.length <= 104
s 由小写英文字母组成
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] 由小写英文字母组成
'''


from typing import Counter


class Solution:
    # 比较 hash表
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        res = []
        s_len = len(s)  # 字符串 s的长度
        words_len = len(words)  # words数组的长度
        one_word_len = len(words[0])  # 单个单词的长度
        if not s_len or not words_len or s_len < one_word_len:
            return res
        all_words_len = words_len * one_word_len  # words数组中拼接字符串的长度，每个单词的长度都相同
        words_counter = Counter(words)  # 获取原始 words数组的 Counter dict

        # 循环字符串 s，因为要向后截取 tmp字符串，所以截止索引要保留出拼接字符串的长度
        for i in range(s_len - all_words_len + 1):
            # 截取与拼接字符串长度相同的字符串
            tmp_words = s[i: i + all_words_len]
            tmp_counter = []
            # 循环截取的字符串，间隔为一个单词的长度
            for j in range(0, len(tmp_words), one_word_len):
                # 根据一个单词的长度截取当前索引的字符串，并放入 tmp Counter中
                tmp_counter.append(tmp_words[j: j + one_word_len])
            # 将最后获取到的 tmp Counter与原始 words Counter进行比较，相等则放入到结果数组中
            if Counter(tmp_counter) == words_counter:
                res.append(i)
        return res

    # 滑动窗口加 hash表计数
    def findSubstring1(self, s: str, words: List[str]) -> List[int]:
        res = []
        s_len = len(s)  # 字符串 s的长度
        words_len = len(words)  # words数组的长度
        one_word_len = len(words[0])  # 单个单词的长度
        if not s_len or not words_len or s_len < one_word_len:
            return res

        words_counter = Counter(words)  # 获取原始 words数组的 Counter dict

        # 以一个单词的长度进行循环，每次从 s字符串的不同起始位置开始匹配，匹配次数最少
        for i in range(one_word_len):
            left = i  # 左指针初始化
            right = i  # 右指针初始化
            tmp_cnt = 0  # 模板字符串计数
            tmp_counter = Counter()  # 模板字符串 Counter
            while right + one_word_len <= s_len:  # while循环条件为右指针加上一个单词长度已经超过 s字符串
                tmp = s[right: right + one_word_len]  # 截取右指针后方的字符串
                right += one_word_len  # 右指针滑动一个单词的长度
                if tmp not in words_counter:  # 如果截取的字符串不存在原始 words的 counter中
                    left = right  # 左指针滑动到右指针的位置
                    tmp_counter.clear()  # Counter清除
                    tmp_cnt = 0  # 模板字符串计数器清空
                else:  # 如果存在原始 words的 counter中
                    tmp_counter[tmp] += 1  # Counter加一
                    tmp_cnt += 1  # 计数器加一
                    # 如果截取的字符串在模板 Counter的数量大于原始数组 Counter的数量，根据左指针截取字符串，并在计数器中减一
                    while tmp_counter[tmp] > words_counter[tmp]:
                        left_tmp = s[left: left + one_word_len]
                        left += one_word_len
                        tmp_counter[left_tmp] -= 1
                        tmp_cnt -= 1
                    # 如果模板计数器等于原始 words长度，则获取当前索引
                    if tmp_cnt == words_len:
                        res.append(left)
        return res
