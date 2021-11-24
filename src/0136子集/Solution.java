import java.util.ArrayList;
import java.util.List;

// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

// 示例 1：
// 输入：nums = [1,2,3]
// 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// 示例 2：
// 输入：nums = [0]
// 输出：[[],[0]]

// 提示：
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同

class Solution {
  /**
   * 回溯算法
   * 
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, res, new ArrayList<>());
    return res;
  }

  private void backtrack(int index, int[] nums, List<List<Integer>> res, List<Integer> tmp) {
    // 将子集 tmp添加到 res中
    res.add(new ArrayList<Integer>(tmp));
    for (int i = index; i < nums.length; i++) {
      tmp.add(nums[i]);
      backtrack(i + 1, nums, res, tmp);
      // 回溯，清除 tmp数组的最后一项
      tmp.remove(tmp.size() - 1);
    }
  }
}
