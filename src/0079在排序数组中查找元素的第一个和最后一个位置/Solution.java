// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
// 如果数组中不存在目标值 target，返回 [-1, -1]。

// 进阶：
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

// 示例 1：
// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]

// 示例 2：
// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]

// 示例 3：
// 输入：nums = [], target = 0
// 输出：[-1,-1]

// 提示：
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int li = this.binarySearch(nums, target, true);
    int ri = this.binarySearch(nums, target, false) - 1;
    // 左右 index符合条件，则返回左右 index
    if (li <= ri && ri < nums.length && nums[li] == target && nums[ri] == target) {
      return new int[] { li, ri };
    }
    return new int[] { -1, -1 };
  }

  /**
   * 二分查找
   * 
   * 通过 lower标志位控制分别查找左侧 index和右侧 index + 1
   * @param nums
   * @param target
   * @param lower
   * @return
   */
  public int binarySearch(int[] nums, int target, boolean lower) {
    int n = nums.length;
    int l = 0;
    int r = n - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      // 中间值大于目标值，右侧指针挪动，同时总长度变化。如果是查找左 index，如果相等也挪动右侧指针
      if (nums[mid] > target || (lower && nums[mid] >= target)) {
        r = mid - 1;
        // 右侧指针挪动，总长度也变化，总长度所在的位置既是与 target相等的值
        n = mid;
      } else {
        l = mid + 1;
      }
    }
    return n;
  }
}
