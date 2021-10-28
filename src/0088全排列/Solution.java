import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

// 示例 1：
// 输入：nums = [1,2,3]
// 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// 示例 2：
// 输入：nums = [0,1]
// 输出：[[0,1],[1,0]]

// 示例 3：
// 输入：nums = [1]
// 输出：[[1]]

// 提示：
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    for (int num : nums) {
      output.add(num);
    }
    backtrack(0, res, output, n);
    return res;
  }

  /**
   * 回溯算法
   * 
   * @param first
   * @param res
   * @param output
   * @param n
   */
  public void backtrack(int first, List<List<Integer>> res, List<Integer> output, int n) {
    // 整个数组交换完成后，填进 res中
    if (first == n) {
      res.add(new ArrayList<Integer>(output));
    }

    // 根据起始位置开始遍历整个数组
    for (int i = first; i < n; i++) {
      // 交换起始位置和当前索引位置的值
      Collections.swap(output, first, i);
      // 继续递归交换剩余位置
      backtrack(first + 1, res, output, n);
      // 回退操作
      Collections.swap(output, first, i);
    }
  }
}
