'''
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
(“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串)
'''


class Solution:
    def longestPalindrome(self, s):
        '''
        方法1
        DP
        '''
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        ans = ''
        for l in range(n):
            for i in range(n):
                j = i + l
                if j >= n:
                    break
                elif l == 0:
                    dp[i][j] = True
                elif l == 1:
                    dp[i][j] = (s[i] == s[j])
                else:
                    dp[i][j] = (dp[i + 1][j - 1] and s[i] == s[j])
                if dp[i][j] and l + 1 > len(ans):
                    ans = s[i: j + 1]
        return ans

if __name__ == '__main__':
    n = 'abcdeedcb'
    ins = Solution()
    final1 = ins.longestPalindrome(n)
    # final2 = ins.numTrees2(n)
    print(final1)
