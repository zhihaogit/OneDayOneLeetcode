// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
// 判断你是否能够到达最后一个下标。

// 示例 1：
// 输入：nums = [2,3,1,1,4]
// 输出：true
// 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

// 示例 2：
// 输入：nums = [3,2,1,0,4]
// 输出：false
// 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

// 提示：
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105

class Solution {
  public boolean canJump(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > maxIndex) {
        return false; // 若当前位置大于最远可达位置，直接返回false
      }
      maxIndex = Math.max(maxIndex, i + nums[i]); // 记录当前可达最远位置
    }
    return true; // 遍历完都没找到不可达位置，那就可达
  }
}
