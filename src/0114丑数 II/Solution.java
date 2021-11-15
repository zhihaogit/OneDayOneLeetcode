// 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
// 丑数 就是只包含质因数（质因子） 2、3、5 的正整数。
// 前20个丑数为：1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30, 32, 36

// 示例 1：
// 输入：n = 10
// 输出：12
// 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。

// 示例 2：
// 输入：n = 1
// 输出：1
// 解释：1 通常被视为丑数。

// 提示：
// 1 <= n <= 1690

class Solution {
  /**
   * 动态规划
   * 
   * @param n
   * @return
   */
  public int nthUglyNumber(int n) {
    int[] dp = new int[n + 1];
    // 最小的丑数是 11
    dp[1] = 1;
    // 维护三个指针
    int p2 = 1;
    int p3 = 1;
    int p5 = 1;
    for (int i = 2; i <= n; i++) {
      // 维护三个丑数
      int num2 = dp[p2] * 2;
      int num3 = dp[p3] * 3;
      int num5 = dp[p5] * 5;
      // 每次取最小的丑数
      dp[i] = Math.min(Math.min(num2, num3), num5);
      // 如果任意一个值相等，指针 + 1
      if (dp[i] == num2) {
        p2++;
      }
      if (dp[i] == num3) {
        p3++;
      }
      if (dp[i] == num5) {
        p5++;
      }
    }
    return dp[n];
  }
}
