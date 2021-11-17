import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

// 示例 1：
// 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出：[[1,6],[8,10],[15,18]]
// 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

// 示例 2：
// 输入：intervals = [[1,4],[4,5]]
// 输出：[[1,5]]
// 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

// 提示：
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

class Solution {
  /**
   * 思路：新建一个数组用来存储结果，用第一个子数组初始化结果数组。
   * 
   * 将原始数组以左边界进行排序。
   * 
   * 按照规律：一个数组的左边界大于一个数组的右边界，则不能进行合并。
   * 
   * 如果可以合并，则用当前数组的右边界去更新可合并区间的右边界。
   * 
   * @param intervals
   * @return
   */
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[0][2];
    }
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> merged = new ArrayList<int[]>();
    for (int i = 0; i < intervals.length; i++) {
      int L = intervals[i][0];
      int R = intervals[i][1];
      if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
        merged.add(new int[] { L, R });
      } else {
        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}
