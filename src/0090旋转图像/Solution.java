// 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

// 示例 1：
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[[7,4,1],[8,5,2],[9,6,3]]

// 示例 2：
// 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

// 示例 3：
// 输入：matrix = [[1]]
// 输出：[[1]]

// 示例 4：
// 输入：matrix = [[1,2],[3,4]]
// 输出：[[3,1],[4,2]]

// 提示：
// matrix.length == n
// matrix[i].length == n
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000

class Solution {
  /**
   * 借助新矩阵
   * 转换规律：(row, col) => (col, n - row - 1)
   * 
   * @param matrix
   */
  public void rotate1(int[][] matrix) {
    int n = matrix.length;
    int[][] newMatrix = new int[n][n];
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        newMatrix[col][n - row - 1] = matrix[row][col];
      }
    }
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        matrix[row][col] = matrix[row][col];
      }
    }
  }

  /**
   * 原地旋转
   * <p>
   * 转换规律:
   * (row, col)                 => (col, n - row - 1)
   * (col, n - row - 1)         => (n - row - 1, n - col - 1)
   * (n - row - 1, n - col - 1) => (n - col - 1, row)
   * (n - col - 1, row)         => (row, col)
   * </p>
   * 
   * @param matrix
   */
  public void rotate2(int[][] matrix) {
    int n = matrix.length;
    // 先遍历行，再遍历列
    for (int row = 0; row < (n + 1) / 2; row++) {
      for (int col = 0; col < n / 2; col++) {
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[n - col - 1][row];
        matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
        matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
        matrix[col][n - row - 1] = tmp;
      }
    }
  }

  /**
   * 用翻转代替旋转
   * 转化规律：
   * 先上下(水平)翻转：(row, col) => (row, n - col - 1);
   * 再主对角线（(x1, y1) => (y1, x1)）翻转：(row, n - col - 1) => (n - col - 1, row)
   *
   * @param matrix
   */
  public void rotate3(int[][] matrix) {
    int n = matrix.length;
    // 先遍历行，再遍历列
    // 上下翻转
    for (int row = 0; row < n / 2; row++) {
      for (int col = 0; col < n; col++) {
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[n - row - 1][col];
        matrix[n - row - 1][col] = tmp;
      }
    }

    // 先遍历行，再遍历列
    // 主对角线翻转
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < row; col++) {
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = tmp;
      }
    }
  }
}
