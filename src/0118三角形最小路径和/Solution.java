import java.util.List;

// 给定一个三角形 triangle ，找出自顶向下的最小路径和。

// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

// 示例 1：
// 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// 输出：11
// 解释：如下面简图所示：
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

// 示例 2：
// 输入：triangle = [[-10]]
// 输出：-10

// 提示：
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104

// 进阶：
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？

class Solution {
  /**
   * 动态规划
   * 
   * 状态转义方程：f[i][j] = min(f[i - 1][j], f[i - 1][j - 1]) + c[i][j]
   * 
   * @param triangle
   * @return
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    for (int i = 1; i < n; i++) {
      List<Integer> arr = triangle.get(i);
      List<Integer> arrPrev = triangle.get(i - 1);
      int m = arr.size();
      for (int j = 0; j < m; j++) {
        int min = 0;
        if (j == 0) {
          min = arrPrev.get(j);
        } else if (j == m - 1) {
          min = arrPrev.get(j - 1);
        } else {
          min = Math.min(arrPrev.get(j - 1), arrPrev.get(j));
        }
        arr.set(j, arr.get(j) + min);
      }
    }

    List<Integer> fin = triangle.get(n - 1);
    int ans = fin.get(0);
    for (int i = 1; i < fin.size(); i++) {
      ans = Math.min(ans, fin.get(i));
    }
    return ans;
  }

  /**
   * 动态规划 + 空间优化版
   * 
   * @param triangle
   * @return
   */
  public int minimumTotal1(List<List<Integer>> triangle) {
    // 以三角形最后一行为基础
    List<Integer> dp = triangle.get(triangle.size() - 1);
    // 从下往上遍历，进行累加，取出第一位即为最小值
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j >= i; j++) {
        dp.set(j, Math.min(dp.get(j), dp.get(j + 1)) + triangle.get(i).get(j));
      }
    }
    return dp.get(0);
  }
}
