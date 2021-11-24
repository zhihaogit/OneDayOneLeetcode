// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

// 示例 1:
// 输入: 2
// 输出: 1
// 解释: 2 = 1 + 1, 1 × 1 = 1。

// 示例 2:
// 输入: 10
// 输出: 36
// 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
// 说明: 你可以假设 n 不小于 2 且不大于 58。

class Solution {
  /**
   * 动态规划
   * 
   * @param n
   * @return
   */
  public int integerBreak(int n) {
    // dp的数据表示当前数据拆分为两个正整数的最大乘积
    int[] dp = new int[n + 1];
    // 边界条件：0不是正整数，1不能再拆分，都为 0
    dp[0] = dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      int maxAns = 0;
      // 0不是正整数，所以循环从 1开始
      for (int j = 1; j < i; j++) {
        // 将 i拆分为 j和 i - j两个整数
        // 如果 i - j不再拆分，此时的乘积为 j * (i - j)
        // 如果 i - j继续拆分，此时的乘积为 j * dp[i - j]，dp[i - j]表示 i - j这个整数拆分为两个整数后的最大乘积
        maxAns = Math.max(Math.max(j * (i - j), j * dp[i - j]), maxAns);
      }
      dp[i] = maxAns;
    }
    return dp[n];
  }
}
