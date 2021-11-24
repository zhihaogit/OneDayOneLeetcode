import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

// 示例 1：
// 输入：nums = [1,2,2]
// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

// 示例 2：
// 输入：nums = [0]
// 输出：[[],[0]]

// 提示：
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

class Solution {
  /**
   * 回溯算法 + 剪枝
   * 
   * @param nums
   * @return
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    // 剪枝的前提，数组排序
    Arrays.sort(nums);
    backtrack(0, nums, res, new ArrayList<>());
    return res;
  }

  private void backtrack(int index, int[] nums, List<List<Integer>> res, List<Integer> tmp) {
    res.add(new ArrayList<>(tmp));
    for (int i = index; i < nums.length; i++) {
      tmp.add(nums[i]);
      backtrack(i + 1, nums, res, tmp);
      // 回溯，去除最后一个元素
      tmp.remove(tmp.size() - 1);
      // 剪枝，去除重复项
      while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
        i++;
      }
    }
  }
}
