// 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

// 进阶：
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

// 示例 1：
// 输入：s = "abc", t = "ahbgdc"
// 输出：true

// 示例 2：
// 输入：s = "axc", t = "ahbgdc"
// 输出：false

// 提示：
// 0 <= s.length <= 100
// 0 <= t.length <= 10^4
// 两个字符串都只由小写字符组成。

class Solution {
  /**
   * 双指针
   * 
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence(String s, String t) {
    int n = s.length();
    int m = t.length();
    // 初始化两个变量，分别代表 s和 t两个字符串的起始位置
    int sLeft = 0;
    int tLeft = 0;
    while (sLeft < n && tLeft < m) {
      // 判断索引所在位置的字符是否相同
      if (s.charAt(sLeft) == t.charAt(tLeft)) {
        sLeft++;
      }
      tLeft++;
    }
    // 最后判定成功，根据 s字符串的位置是否到达最大长度
    return n == sLeft;
  }

  /**
   * 动态规划
   * 
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence1(String s, String t) {
    int n = s.length();
    int m = t.length();

    // 初始化 dp数组，dp[i][j] 表示字符串 t中从位置 i开始往后字符 j第一次出现的位置
    int[][] dp = new int[m + 1][26];
    // 初始化边界情况，表示没有出现
    for (int i = 0; i < 26; i++) {
      dp[m][i] = m;
    }

    // 从后往前迭代字符串
    for (int i = m - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        if (t.charAt(i) == j + 'a') {
          // 如果 i位置出现了 j字符串，记录 i位置
          dp[i][j] = i;
        } else {
          // 不相等，则进行状态转移
          dp[i][j] = dp[i + 1][j];
        }
      }
    }

    // 初始化 t字符串的起始位置
    int add = 0;
    for (int i = 0; i < n; i++) {
      // 如果 dp中没有 s的某个字符，return false
      if (dp[add][s.charAt(i) - 'a'] == m) {
        return false;
      }
      // 找得到，则从找到的索引的后一位开始找
      add = dp[add][s.charAt(i) - 'a'] + 1;
    }
    return true;
  }
}
