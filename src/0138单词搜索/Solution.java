// 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

// 示例 1：
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// 输出：true

// 示例 2：
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// 输出：true

// 示例 3：
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// 输出：false

// 提示：
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成

// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？

class Solution {
  /**
   * 回溯算法
   * 
   * @param board
   * @param word
   * @return
   */
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    // 记录当前坐标是否被访问过，已访问过则不再重复计算
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 查找每一个坐标的情况
        boolean flag = check(board, word, visited, i, j, 0);
        if (flag) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean check(char[][] board, String word, boolean[][] visited, int x, int y, int index) {
    if (board[x][y] != word.charAt(index)) {
      // 如果当前坐标与字符串某位对不上，则 return false
      return false;
    } else if (index == word.length() - 1) {
      // 访问到字符串的末尾，并且前面位置仍能匹配上，则 return true
      return true;
    }
    // 标记当前坐标已访问
    visited[x][y] = true;
    // 当前坐标的上下左右的偏移量
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    boolean result = false;
    for (int[] direction : directions) {
      // 使用循环，分别赋值当前坐标上下左右的坐标
      int newX = x + direction[0];
      int newY = y + direction[1];
      // 坐标的边界条件
      if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
        // 没访问过的坐标参与查找
        if (!visited[newX][newY]) {
          boolean flag = check(board, word, visited, newX, newY, index + 1);
          if (flag) {
            result = true;
            break;
          }
        }
      }
    }
    // 回溯，标记当前坐标没有被访问过
    visited[x][y] = false;
    return result;
  }
}
