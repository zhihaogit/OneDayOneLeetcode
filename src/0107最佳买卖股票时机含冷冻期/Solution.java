// 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

// 示例:
// 输入: [1,2,3,0,2]
// 输出: 3 
// 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

class Solution {
  /**
   * 动态规划
   * 
   * f[i][0] 持有股票的最大收益：f[i][0] = max(f[i - 1][0], f[i - 1][2] - prices[i])
   * 
   * 值来源于前一天持有股票 f[i - 1][0]和前一天不持有股票不处于冷冻期，在今天买入股票 f[i - 1][2] - prices[i]的最大值
   * 
   * f[i][1] 不持有股票，处于冷冻期的最大收益：f[i][0] = max(f[i - 1][0] + prices[i])
   * 
   * 值来源于前一天持有股票，并在今天卖出 f[i - 1][0] + prices[i]
   * 
   * f[i][2] 不持有股票，不处于冷冻期的最大收益：f[i][0] = max(f[i - 1][2] + f[i - 1][1])
   * 
   * 值来源于前一天是不持有股票，不处于冷冻期 f[i - 1][2]和前一天不持有股票，处于冷冻期 f[i - 1][1]的最大值
   * 
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][3];
    // 持有股票的初始值就是在第一天买入股票
    dp[0][0] = -prices[0];
    // 不持有，冷冻期的初始值为 0
    dp[0][1] = 0;
    // 不持有，不是冷冻期的初始值为 0
    dp[0][2] = 0;
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
      dp[i][1] = dp[i - 1][0] + prices[i];
      dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
    }
    // 最终值应该是在不持有的状态下找最大值
    return Math.max(dp[n - 1][1], dp[n - 1][2]);
  }

  /**
   * 动态规划 + 滚动数组
   * 
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    int dp0 = -prices[0];
    int dp1 = 0;
    int dp2 = 0;
    for (int i = 1; i < prices.length; i++) {
      int newDp0 = Math.max(dp0, dp2 - prices[i]);
      int newDp1 = dp0 + prices[i];
      int newDp2 = Math.max(dp1, dp2);
      dp0 = newDp0;
      dp1 = newDp1;
      dp2 = newDp2;
    }
    return Math.max(dp1, dp2);
  }
}
