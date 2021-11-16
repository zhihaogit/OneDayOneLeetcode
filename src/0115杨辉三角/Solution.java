import java.util.ArrayList;
import java.util.List;

// 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。

// 示例 1:
// 输入: numRows = 5
// 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// 示例 2:
// 输入: numRows = 1
// 输出: [[1]]

// 提示:
// 1 <= numRows <= 30

class Solution {
  /**
   * 动态规划
   * 
   * @param numRows
   * @return
   */
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    // 形成一个 n行 n列的二维数组
    int[][] dp = new int[numRows][numRows];
    dp[0][0] = 1;
    List<Integer> l = new ArrayList<>();
    l.add(1);
    result.add(l);
    for (int i = 1; i < numRows; i++) {
      List<Integer> tmp = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        // 边界条件，最左边为 1
        if (j == 0) {
          dp[i][j] = 1;
        } else {
          // dp[i][j] = 左上方 + 右上方
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        }
        tmp.add(dp[i][j]);
      }
      result.add(tmp);
    }
    return result;
  }
}
