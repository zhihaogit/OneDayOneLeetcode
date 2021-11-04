// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

// 注意：给定 n 是一个正整数。

// 示例 1：
// 输入： 2
// 输出： 2
// 解释： 有两种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶
// 2.  2 阶

// 示例 2：
// 输入： 3
// 输出： 3
// 解释： 有三种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶 + 1 阶
// 2.  1 阶 + 2 阶
// 3.  2 阶 + 1 阶

class Solution {
  /**
   * 动态规划
   * 状态转移方程：f(x) = f(x - 1) + f(x - 2)
   * 台阶数： x = 0, 1, 2, 3, 4, 5
   * 方案数： n = 0, 1, 2, 3, 5, 8
   *
   * @param n
   * @return
   */
  public int climbStairs(int n) {
    int p1 = 0;
    int p2 = 0;
    int p3 = 1;
    // 滚动数组思想
    for (int i = 1; i <= n; i++) {
      p1 = p2;
      p2 = p3;
      p3 = p1 + p2;
    }
    return p3;
  }

  public int climbStairs1(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int[] arr = new int[n + 1];
    arr[0] = 1;
    arr[1] = 1;
    for (int i = 2; i <= n; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[n];
  }
}
