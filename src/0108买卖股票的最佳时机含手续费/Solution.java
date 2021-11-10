// 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
// 返回获得利润的最大值。

// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

// 示例 1：
// 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
// 输出：8
// 解释：能够达到的最大利润:  
// 在此处买入 prices[0] = 1
// 在此处卖出 prices[3] = 8
// 在此处买入 prices[4] = 4
// 在此处卖出 prices[5] = 9
// 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8

// 示例 2：
// 输入：prices = [1,3,7,5,10,3], fee = 3
// 输出：6

// 提示：
// 1 <= prices.length <= 5 * 104
// 1 <= prices[i] < 5 * 104
// 0 <= fee < 5 * 104

class Solution {
  /**
   * 动态规划
   * 
   * f[i][0] 表示没有股票的最大收益：f[i][0] = max(f[i - 1][0], f[i - 1][1] + prices[i] - fee)
   * 
   * 值来源于前一天没有股票的值 f[i - 1][0]和前一天有股票，这天卖出 f[i - 1][1] + prices[i] - fee的最大值
   * 
   * f[i][1] 表示有一支股票的最大收益:f[i][1] = max(f[i - 1][1], f[i - 1][0] - prices[i])
   * 
   * 值来源于前一天有股票的值 f[i - 1][1]和 前一天没有股票，这天买入 f[i - 1][0] - prices[i]的最大值
   * 
   * @param prices
   * @param fee
   * @return
   */
  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    // 支付手续费放在了卖出的时候进行计算，买入不再支付手续费
    dp[0][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
  }

  /**
   * 动态规划 + 滚动数组
   * 
   * @param prices
   * @param fee
   * @return
   */
  public int maxProfit1(int[] prices, int fee) {
    int dp0 = 0;
    int dp1 = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      int newDp0 = Math.max(dp0, dp1 + prices[i] - fee);
      dp1 = Math.max(dp1, dp0 - prices[i]);
      dp0 = newDp0;
    }
    return dp0;
  }

  /**
   * 贪心算法
   * 
   * @param prices
   * @param fee
   * @return
   */
  public int maxProfit2(int[] prices, int fee) {
    int ans = 0;
    int buy = prices[0] + fee;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] + fee < buy) {
        // 如果当前买入价格低于之前的买入价格，更新买入价格
        buy = prices[i] + fee;
      } else if (prices[i] > buy) {
        // 如果当前卖出价格高于之前买入价格，卖出并计入收益
        ans += prices[i] - buy;
        // 为防止当前解不是最优解，直接在当天买入，这样可以抵消，即 prices[i + 1] - prices[i] + (prices[i] - buy)
        buy = prices[i];
      }
    }
    return ans;
  }
}
