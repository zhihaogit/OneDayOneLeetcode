// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

// 网格中的障碍物和空位置分别用 1 和 0 来表示。

// 示例 1：
// 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// 输出：2
// 解释：
// 3x3 网格的正中间有一个障碍物。
// 从左上角到右下角一共有 2 条不同的路径：
// 1. 向右 -> 向右 -> 向下 -> 向下
// 2. 向下 -> 向下 -> 向右 -> 向右

// 示例 2：
// 输入：obstacleGrid = [[0,1],[0,0]]
// 输出：1

// 提示：
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] 为 0 或 1

class Solution {
  /**
   * 动态规划
   * 
   * 状态转移方程：f[i][j] = f[i - 1][j] + f[i][j - 1]
   * 
   * @param obstacleGrid
   * @return
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    // 初始化第一列的值，如果有一个值为 1，则不能再向下移动了
    for (int i = 0; i < m; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      }
      dp[i][0] = 1;
    }

    // 初始化第一行的值，如果有一个值为 1，则不能再向右移动了
    for (int i = 0; i < n; i++) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
      dp[0][i] = 1;
    }

    // 从行和列进行遍历，如果当前位置为 1，则跳过，继续下一次循环
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          continue;
        }
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
}
