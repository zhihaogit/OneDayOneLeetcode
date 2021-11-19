// 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

// 示例 1：
// 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// 输出：4

// 示例 2：
// 输入：matrix = [["0","1"],["1","0"]]
// 输出：1

// 示例 3：
// 输入：matrix = [["0"]]
// 输出：0

// 提示：
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'

class Solution {
  /**
   * 动态规划
   * 
   * 状态转移方程：f[i][j] = min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1
   * 
   * @param matrix
   * @return
   */
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int maxSide = 0;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 如果当前格子中是 '1'，有组成正方形的可能
        if (matrix[i][j] == '1') {
          if (i == 0 || j == 0) {
            // 处理边界问题
            dp[i][j] = 1;
          } else {
            // 以此位置作为正方形的右下角，那此时的最长边取决于相邻三个位置的最小值
            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          }
        }
        maxSide = Math.max(maxSide, dp[i][j]);
      }
    }
    return maxSide * maxSide;
  }
}
