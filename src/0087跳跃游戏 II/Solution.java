// 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
// 假设你总是可以到达数组的最后一个位置。

// 示例 1:
// 输入: nums = [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

// 示例 2:
// 输入: nums = [2,3,0,1,4]
// 输出: 2

// 提示:
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000

class Solution {
  /**
   * 反向查找出发位置
   * 
   * @param nums
   * @return
   */
  public int jump1(int[] nums) {
    int position = nums.length - 1;
    int step = 0;

    // 确保位置是有效地
    while (position > 0) {
      // 从左到右遍历数组
      for (int i = 0; i < position; i++) {
        // 如果当前索引加上当前值大于等于终点位置，重置位置索引，跳跃次数 + 1
        if (i + nums[i] >= position) {
          position = i;
          step++;
          break;
        }
      }
    }
    // 最后将跳跃次数 return出来
    return step;
  }

  /**
   * 正向查找可到达的最大位置
   * 
   * @param nums
   * @return
   */
  public int jump2(int[] nums) {
    // 设置每次跳跃的边界
    int end = 0;
    // 记录可跳跃的最大位置
    int maxPosition = 0;
    // 记录跳跃次数
    int step = 0;
    // 从左到右循环数组
    for (int i = 0; i < nums.length - 1; i++) {
      // 求得最大的可跳跃位置
      maxPosition = Math.max(maxPosition, i + nums[i]);
      // 如果循环时，当前索引等于边界值，使用最大跳跃位置重置边界值，跳跃次数 + 1
      if (i == end) {
        end = maxPosition;
        step++;
      }
    }
    // 最后将跳跃次数 return出来
    return step;
  }
}
