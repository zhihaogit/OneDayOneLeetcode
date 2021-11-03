// 泰波那契序列 Tn 定义如下： 
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

// 示例 1：
// 输入：n = 4
// 输出：4
// 解释：
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4

// 示例 2：
// 输入：n = 25
// 输出：1389537

// 提示：
// 0 <= n <= 37
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。

class Solution {
  /**
   * 动态规划
   * 状态转移方程：f(n) = f(n - 1) + f(n - 2) + f(n - 3)
   *
   * @param n
   * @return
   */
  public int tribonacci(int n) {
    if (n < 2) {
      return n;
    }
    if (n == 2) {
      return 1;
    }
    // 四个变量的初始值为i == 3时，数组的前四位元素值
    int p1 = 0;
    int p2 = 1;
    int p3 = 1;
    int p4 = p1 + p2 + p3;
    // 滚动数组思想向后迭代，不断交换位置
    for (int i = 4; i <= n; i++) {
      p1 = p2;
      p2 = p3;
      p3 = p4;
      p4 = p1 + p2 + p3;
    }
    return p4;
  }

  /**
   * 带备忘录的递归实现
   *
   * @param n
   * @return
   */
  public int tribonacci1(int n) {
    int[] arr = new int[n + 1];
    return dfs(arr, n);
  }

  public int dfs(int[] arr, int n) {
    if (n == 0) {
      return 0;
    } else if (n < 3) {
      return 1;
    } else if (n == 3) {
      return 2;
    } else if (arr[n] != 0) {
      return arr[n];
    } else {
      arr[n] = dfs(arr, n - 1) + dfs(arr, n - 2) + dfs(arr, n - 3);
      return arr[n];
    }
  }
}
