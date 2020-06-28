'''
给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
你需要根据这个学生的出勤记录判断他是否会被奖赏。

示例 1:
输入: "PPALLP"
输出: True

示例 2:
输入: "PPALLL"
输出: False
'''
import re

class Solution:
    # def checkRecord(self, s: str) -> bool:
    def checkRecord1(self, s):
        ACount = LLLCount = 0
        for i in s:
            if i == 'A':
                ACount += 1
                if ACount >= 2: return False
                LLLCount = 0
            elif i == 'L':
                LLLCount += 1
                if LLLCount >= 3: return False
            else:
                LLLCount = 0
        return True

    def checkRecord2(slef, s):
        return s.count('A') < 2 and s.count('LLL') < 1

    def checkRecord3(slef, s):
        return not(re.search(r'A.*A|LLL', s))


if __name__ == '__main__':
    into1 = 'PPALLP'
    into2 = 'PPALLL'

    ins = Solution()
    print(ins.checkRecord3(into2))
