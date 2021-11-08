// 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

// 示例 1:
// 输入: [2,3,-2,4]
// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。

// 示例 2:
// 输入: [-2,0,-1]
// 输出: 0
// 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

class Solution {
  /**
   * 动态规划
   * 
   * 由于负数乘以负数等于正数，我们需要找到负数的最小值，也需要找到正数的最大值，各自用数组存储进行比较
   * 
   * @param nums
   * @return
   */
  public int maxProduct(int[] nums) {
    int n = nums.length;
    int[] maxF = new int[n];
    int[] minF = new int[n];
    System.arraycopy(nums, 0, maxF, 0, n);
    System.arraycopy(nums, 0, minF, 0, n);
    for (int i = 1; i < n; i++) {
      // 找最大值需要比较三个值：max(最大的正数 * 当前数值, 最小的负数 * 当前数值, 当前数值)
      maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
      // 找最大值需要比较三个值：min(最大的正数 * 当前数值, 最小的负数 * 当前数值, 当前数值)
      minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(maxF[i - 1] * nums[i], nums[i]));
    }
    // 遍历最大值数组，找出最大值
    int max = maxF[0];
    for (int i = 1; i < maxF.length; i++) {
      max = Math.max(maxF[i], max);
    }
    return max;
  }

  /**
   * 动态规划 + 滚动数组
   * 
   * @param nums
   * @return
   */
  public int maxProduct1(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    int ans = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int mx = max;
      int mn = min;
      max = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
      min = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
      ans = Math.max(ans, max);
    }
    return ans;
  }
}
