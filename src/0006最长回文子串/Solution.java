// 给你一个字符串 s，找到 s 中最长的回文子串。

// 示例 1：
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。

// 示例 2：
// 输入：s = "cbbd"
// 输出："bb"

// 示例 3：
// 输入：s = "a"
// 输出："a"

// 示例 4：
// 输入：s = "ac"
// 输出："a"

// 提示：
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成

class Solution {

  /**
   * 中心扩散法
   * 
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    int n = s.length();
    // 单个元素的字符串一定是回文子串
    if (n < 2) {
      return s;
    }
    int maxStart = 0;
    int maxEnd = 0;
    for (int i = 0; i < n; i++) {
      int len = expandAroundCenter(s, i, i);
      int len1 = expandAroundCenter(s, i, i + 1);
      int maxLen = Math.max(len, len1);
      if (maxLen > maxEnd - maxStart) {
        maxStart = i - (maxLen - 1) / 2;
        maxEnd = i + maxLen / 2;
      }
    }
    return s.substring(maxStart, maxEnd + 1);
  }

  // 不断比较左右边界的值，并重置左右边界的索引
  public int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  /**
   * 动态规划
   * 
   * @param s
   * @return
   */
  public String longestPalindrome1(String s) {
    int n = s.length();
    // 单个元素的字符串一定是回文子串
    if (n < 2) {
      return s;
    }
    // 记录回文子串的最大长度
    int maxLen = 0;
    // 记录回文子串的左边界索引
    int maxStart = 0;
    // 记录回文子串的右边界索引
    int maxEnd = 0;
    // dp[left][right]表示字符串中 left到 right位置之间是否为回文子串
    boolean[][] dp = new boolean[n][n];
    // 外层遍历数组，索引为子串的右边界
    for (int right = 1; right < n; right++) {
      // 内层遍历小于右边界的子串，寻找合适的左边界
      for (int left = 0; left < right; left++) {
        // 判断是否为回文子串的条件：
        // 1. 左边界和右边界所在的值相同，必要条件
        // 2. 值相同的同时左边界和右边界在同一位置，直接相邻或者中间有一位
        // 3. 如果左边界和右边界的距离比较大，则看他们内部的子串是否为回文，子串的坐标为 (left + 1, right - 1)
        if (s.charAt(right) == s.charAt(left) && (right - left <= 2 || dp[left + 1][right - 1])) {
          dp[left][right] = true;
          // 尽可能地更新回文子串的最大长度，并记录此时的左右边界索引
          if (right - left + 1 > maxLen) {
            maxLen = right - left + 1;
            maxStart = left;
            maxEnd = right;
          }
        }
      }
    }
    // 根据左右索引，截取出最长回文子串
    return s.substring(maxStart, maxEnd + 1);
  }
}
