// 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
// 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
// 请你返回乘积为正数的最长子数组长度。

// 示例  1：
// 输入：nums = [1,-2,-3,4]
// 输出：4
// 解释：数组本身乘积就是正数，值为 24 。

// 示例 2：
// 输入：nums = [0,1,-2,-3,-4]
// 输出：3
// 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
// 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。

// 示例 3：
// 输入：nums = [-1,-2,-3,0,1]
// 输出：2
// 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。

// 示例 4：
// 输入：nums = [-1,2]
// 输出：1

// 示例 5：
// 输入：nums = [1,2,3,5,-6,4,0,10]
// 输出：4

// 提示：
// 1 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9

class Solution {
  /**
   * 动态规划
   * 
   * @param nums
   * @return
   */
  public int getMaxLen(int[] nums) {
    int n = nums.length;
    // 存储乘积为正数的最大长度
    int[] dpPositive = new int[n];
    // 存储乘积为负数的最大长度
    int[] dpNegative = new int[n];
    if (nums[0] > 0) {
      dpPositive[0] = 1;
    } else if (nums[0] < 0) {
      dpNegative[0] = 1;
    }
    // 存储遍历过程中，乘积为正数的最大长度
    int maxLength = dpPositive[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] > 0) {
        // 正数相乘，乘积为正数，正数数组直接加 1
        dpPositive[i] = dpPositive[i - 1] + 1;
        // 如果负数数组中前一位有值，则加 1，前一位为 0，当前位置仍为 0
        dpNegative[i] = dpNegative[i - 1] > 0 ? dpNegative[i - 1] + 1 : 0;
      } else if (nums[i] < 0) {
        // 乘以负数时，看负数数组中前一位，负负得正，否则再多乘积也是 0
        dpPositive[i] = dpNegative[i - 1] > 0 ? dpNegative[i - 1] + 1 : 0;
        // 前面再多的正数乘以负数，也都是负数
        dpNegative[i] = dpPositive[i - 1] + 1;
      } else {
        // 等于 0，乘积为 0，当前位置为 0
        dpPositive[i] = 0;
        dpNegative[i] = 0;
      }
      // 更新乘积为正数的最大长度
      maxLength = Math.max(maxLength, dpPositive[i]);
    }
    return maxLength;
  }

  /**
   * 动态规划 + 滚动数组
   * 
   * @param nums
   * @return
   */
  public int getMaxLen1(int[] nums) {
    int positive = 0;
    int negative = 0;
    if (nums[0] > 0) {
      positive = 1;
    } else if (nums[0] < 0) {
      negative = 1;
    }
    int maxLength = positive;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        positive++;
        negative = negative > 0 ? negative + 1 : 0;
      } else if (nums[i] < 0) {
        int newPositive = negative > 0 ? negative + 1 : 0;
        negative = positive + 1;
        positive = newPositive;
      } else {
        positive = 0;
        negative = 0;
      }
      maxLength = Math.max(maxLength, positive);
    }
    return maxLength;
  }
}
