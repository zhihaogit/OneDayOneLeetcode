// 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。

// 示例 1：
// 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
// 输出：13
// 解释：下面是两条和最小的下降路径，用加粗+斜体标注：
// [[2,1,3],      [[2,1,3],
//  [6,5,4],       [6,5,4],
//  [7,8,9]]       [7,8,9]]

// 示例 2：
// 输入：matrix = [[-19,57],[-40,-5]]
// 输出：-59
// 解释：下面是一条和最小的下降路径，用加粗+斜体标注：
// [[-19,57],
//  [-40,-5]]

// 示例 3：
// 输入：matrix = [[-48]]
// 输出：-48

// 提示：
// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100

class Solution {
  /**
   * 动态规划
   * 
   * 自上而下遍历原数组，修改原数组，当前行的最小值加上上一行的最小值
   * 
   * 动态转移方程：f[i][j] = min(f[i - 1][j - 1], f[i - 1][j], f[i - 1][j + 1]) + c[i][j]
   * 
   * @param matrix
   * @return
   */
  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    // 从第二行开始遍历，防止 i - 1超出数组索引
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int min;
        // 边界情况取值
        if (j == 0) {
          min = Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
        } else if (j == n - 1) {
          min = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
        } else {
          min = Math.min(Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]), matrix[i - 1][j + 1]);
        }
        matrix[i][j] += min;
      }
    }
    int ans = matrix[n - 1][0];
    for (int i = 1; i < n; i++) {
      ans = Math.min(ans, matrix[n - 1][i]);
    }
    return ans;
  }
}
