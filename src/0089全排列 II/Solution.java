import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

// 示例 1：
// 输入：nums = [1,1,2]
// 输出：
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]

// 示例 2：
// 输入：nums = [1,2,3]
// 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// 提示：
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10

class Solution {
  boolean[] vis;

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    // 记录当前访问的数组数据的索引
    vis = new boolean[nums.length];
    // 排序数组，相同值的项会排在一起
    Arrays.sort(nums);
    backtrack(nums, res, perm, 0);
    return res;
  }

  /**
   * 回溯法
   * 
   * @param nums
   * @param res
   * @param perm
   * @param index
   */
  public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> perm, int index) {
    // 如果索引等于数组的长度，说明已经填充完毕
    if (index == nums.length) {
      res.add(new ArrayList<>(perm));
      return;
    }

    // 从零开始遍历数组
    for (int i = 0; i < nums.length; i++) {
      // 剪枝操作，条件为当前项已被访问，或者当前值与前一个值相等，前一个值也没被访问过
      if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
        continue;
      }
      perm.add(nums[i]);
      // 当前索引标记为已访问
      vis[i] = true;
      backtrack(nums, res, perm, index + 1);
      // 回退操作
      vis[i] = false;
      perm.remove(index);
    }
  }
}
