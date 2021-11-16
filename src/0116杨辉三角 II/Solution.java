import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。

// 示例 1:
// 输入: rowIndex = 3
// 输出: [1,3,3,1]

// 示例 2:
// 输入: rowIndex = 0
// 输出: [1]

// 示例 3:
// 输入: rowIndex = 1
// 输出: [1,1]

// 提示:
// 0 <= rowIndex <= 33

// 进阶：
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？

class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> dp = new ArrayList<Integer>();
    dp.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      dp.add(0);
      for (int j = i; j > 0; j--) {
        dp.set(j, dp.get(j) + dp.get(j - 1));
      }
    }
    return dp;
  }
}
