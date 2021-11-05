// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

// 示例 1：
// 输入：nums = [2,3,2]
// 输出：3
// 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

// 示例 2：
// 输入：nums = [1,2,3,1]
// 输出：4
// 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//      偷窃到的最高金额 = 1 + 3 = 4 。

// 示例 3：
// 输入：nums = [0]
// 输出：0

// 提示：
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000

class Solution {
  /**
   * 动态规划
   *
   * 对比`打家劫舍`，此题多了环形要求，所以第一家和最后一家不能同时被偷，于是就有两种偷盗的方式 -> 第一家到倒数第二家，第二家到倒数第一家
   *
   * 分别计算 0 ~ (n - 2)和 1 ~ (n - 1)这两次的价值，取最大的那个
   *
   * 偷窃第 k 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额为前 k-2 间房屋的最高总金额与第 k 间房屋的金额之和
   *
   * 不偷窃第 k 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额
   *
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return nums[0];
    }
    if (n == 2) {
      return Math.max(nums[0], nums[1]);
    }
    return Math.max(robOnce(0, n - 2, nums), robOnce(1, n - 1, nums));
  }

  // 滚动数组
  public int robOnce(int start, int end, int[] nums) {
    int first = nums[start];
    int second = Math.max(nums[start], nums[start + 1]);
    for (int i = start + 2; i <= end; i++) {
      int next = Math.max(first + nums[i], second);
      first = second;
      second = next;
    }
    return second;
  }

  // 缓存
  public int rob1(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return nums[0];
    }
    if (n == 2) {
      return Math.max(nums[0], nums[1]);
    }
    // 计算 0 ~ (n - 2)
    int[] dp0 = new int[n + 1];
    dp0[0] = nums[0];
    dp0[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n - 1; i++) {
      dp0[i] = Math.max(dp0[i - 2] + nums[i], dp0[i - 1]);
    }
    int dp0Res = dp0[n - 2];

    // 计算 1 ~ (n - 1)
    int[] dp1 = new int[n + 2];
    dp1[0] = 0;
    dp1[1] = nums[1];
    for (int i = 2; i < n; i++) {
      dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
    }
    int dp1Res = dp1[n - 1];

    return Math.max(dp0Res, dp1Res);
  }
}
