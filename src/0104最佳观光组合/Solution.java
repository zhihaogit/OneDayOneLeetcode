// 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
// 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
// 返回一对观光景点能取得的最高分。

// 示例 1：
// 输入：values = [8,1,5,2,6]
// 输出：11
// 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

// 示例 2：
// 输入：values = [1,2]
// 输出：2

// 提示：
// 2 <= values.length <= 5 * 104
// 1 <= values[i] <= 1000

class Solution {
  /**
   * 遍历
   * 
   * @param values
   * @return
   */
  public int maxScoreSightseeingPair(int[] values) {
    int cur = values[0] + 0;
    int ans = 0;
    for (int i = 1; i < values.length; i++) {
      ans = Math.max(cur + values[i] - i, ans);
      cur = Math.max(cur, values[i] + i);
    }
    return ans;
  }

  /**
   * 动态规划
   * 
   * 状态转移方程：dp[j] = max(dp[j - 1], values[j - 1] + j - 1)
   * 
   * @param values
   * @return
   */
  public int maxScoreSightseeingPair1(int[] values) {
    int n = values.length;
    int ans = 0;
    int[] dp = new int[n];
    dp[0] = values[0] + 0;
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1], values[i - 1] + i - 1);
      ans = Math.max(ans, dp[i] + values[i] - i);
    }
    return ans;
  }
}
