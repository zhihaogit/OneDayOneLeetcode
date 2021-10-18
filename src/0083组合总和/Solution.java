import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。

// 示例 1：
// 输入: candidates = [2,3,6,7], target = 7
// 输出: [[7],[2,2,3]]

// 示例 2：
// 输入: candidates = [2,3,5], target = 8
// 输出: [[2,2,2,2],[2,3,3],[3,5]]

// 示例 3：
// 输入: candidates = [2], target = 1
// 输出: []

// 示例 4：
// 输入: candidates = [1], target = 1
// 输出: [[1]]

// 示例 5：
// 输入: candidates = [1], target = 2
// 输出: [[1,1]]

// 提示：
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500

class Solution {

  /**
   * 回溯算法（back tracking）（探索与回溯法） 是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。
   * 但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”
   * 
   * @param candidates
   * @param target
   * @return
   */
  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    // 已组合的数据
    List<Integer> combine = new ArrayList<>();
    // 最终解
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    dfs1(candidates, target, ans, combine, 0);
    return ans;
  }

  public void dfs1(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
    if (index == candidates.length) {
      return;
    }
    if (target == 0) {
      ans.add(new ArrayList<Integer>(combine));
      return;
    }

    // 可以选择跳过不用第 index 个数
    dfs1(candidates, target, ans, combine, index + 1);

    // 也可以选择使用第 index 个数
    if (target >= candidates[index]) {
      combine.add(candidates[index]);
      // 每个数字可以被无限制重复选取
      dfs1(candidates, target - candidates[index], ans, combine, index);
      // combine数组也要进行回溯
      combine.remove(combine.size() - 1);
    }
  }

  /**
   * 回溯算法 + 剪枝
   * 
   * @param candidates
   * @param target
   * @return
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    int len = candidates.length;
    // 最终解
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (len == 0) {
      return ans;
    }
    // 已组合的数据
    List<Integer> combine = new ArrayList<>();
    // 剪枝的前提是排序数组
    Arrays.sort(candidates);
    dfs2(candidates, target, ans, combine, len, 0);
    return ans;
  }

  public void dfs2(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int len, int index) {
    if (target == 0) {
      ans.add(new ArrayList<Integer>(combine));
      return;
    }
    for (int i = index; i < len; i++) {
      if (target - candidates[i] < 0) {
        break;
      }
      combine.add(candidates[i]);
      dfs2(candidates, target - candidates[i], ans, combine, len, i);
      combine.remove(combine.size() - 1);
    }
  }
}
