// 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

// 示例 1:
// 输入: prices = [7,1,5,3,6,4]
// 输出: 7
// 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

// 示例 2:
// 输入: prices = [1,2,3,4,5]
// 输出: 4
// 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

// 示例 3:
// 输入: prices = [7,6,4,3,1]
// 输出: 0
// 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

// 提示：
// 1 <= prices.length <= 3 * 104
// 0 <= prices[i] <= 104

class Solution {
  /**
   * 动态规划
   * 
   * 对于用户来说，只有有一支股票和没有股票的这两种状态
   * 
   * dp[i][0]表示当前没有股票时的最大收益，取值来源于前一天没有股票的最大收益，或者前一天有一支股票并以今日的价格卖出
   * 
   * dp[i][1]表示当前手里有一支股票时的最大收益，取值来源于前一天有一支股票，或者前一天没有股票并以今日的价格买入一支
   * 
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    // 第 0天时，没有股票的最大收益为 0，有一支股票的最大收益为今日的价格，即为负数的支出
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
  }

  /**
   * 动态规划 + 滚动数组
   * 
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    int dpi0 = 0;
    int dpi1 = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      int newDpi0 = Math.max(dpi0, dpi1 + prices[i]);
      int newDpi1 = Math.max(dpi1, dpi0 - prices[i]);
      dpi0 = newDpi0;
      dpi1 = newDpi1;
    }
    return dpi0;
  }

  /**
   * 贪心算法
   * 
   * 只能反馈最优解，并不能表示出交易的过程
   * 
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int ans = 0;
    for (int i = 1; i < prices.length; i++) {
      ans += Math.max(0, prices[i] - prices[i - 1]);
    }
    return ans;
  }
}
