// 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

// 示例 1：
// 输入：s = "bbbab"
// 输出：4
// 解释：一个可能的最长回文子序列为 "bbbb" 。

// 示例 2：
// 输入：s = "cbbd"
// 输出：2
// 解释：一个可能的最长回文子序列为 "bb" 。

// 提示：
// 1 <= s.length <= 1000
// s 仅由小写英文字母组成

class Solution {
  /**
   * 动态规划
   * 
   * @param s
   * @return
   */
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    // dp[left][right]表示字符串中 left到 right位置之间是否为回文子串
    int[][] dp = new int[n][n];
    // 外层循环数组，从末尾开始，作为左边界
    for (int left = n - 1; left >= 0; left--) {
      // 边界情况，任意长度为 1的子串都是回文子串
      dp[left][left] = 1;
      // 内层循环以左边界 + 1为起点，寻找合适的右边界
      for (int right = left + 1; right < n; right++) {
        // 状态转移：
        // 1. 如果左右边界的值相同，取回文子串的长度计数，再加左右边界字符的个数
        // 2. 如果不相同，取左右两个子串的最大值进行保留
        if (s.charAt(left) == s.charAt(right)) {
          dp[left][right] = dp[left + 1][right - 1] + 2;
        } else {
          dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
        }
      }
    }
    return dp[0][n - 1];
  }
}
