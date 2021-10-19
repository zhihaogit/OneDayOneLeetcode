import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
// candidates 中的每个数字在每个组合中只能使用一次。
// 注意：解集不能包含重复的组合。 

// 示例 1:
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
// 输出:
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// 示例 2:
// 输入: candidates = [2,5,2,1,2], target = 5,
// 输出:
// [
// [1,2,2],
// [5]
// ]

// 提示:
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

class Solution {
  // 回溯 + 剪枝
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    int len = candidates.length;
    if (len == 0) {
      return ans;
    }
    List<Integer> combine = new ArrayList<>();
    // 排序 candidates数组
    Arrays.sort(candidates);
    dfs(candidates, ans, combine, target, len, 0);
    return ans;
  }

  public void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> combine, int target, int len, int index) {
    if (target == 0) {
      // 找到符合 target的值
      ans.add(new ArrayList<>(combine));
    }

    for (int i = index; i < len; i++) {
      // 在一个从小到大排序的数组中，如果 target值小于当前值，则后续值都不符合条件
      if (target - candidates[i] < 0) {
        break;
      }
      // 题意要求不能重复使用数组中的数字，那么在一个从小到大排序的数组中，如果当前值与前一个值相等，则跳过当前循环，继续下一次循环
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      combine.add(candidates[i]);
      // 不能重复使用数字，递归查找则直接从后一个值开始
      dfs(candidates, ans, combine, target - candidates[i], len, i + 1);
      combine.remove(combine.size() - 1);
    }
  }
}
