import java.util.HashMap;
import java.util.Map;

// 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
// F(0) = 0，F(1) = 1
// F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 给你 n ，请计算 F(n) 。

// 示例 1：
// 输入：2
// 输出：1
// 解释：F(2) = F(1) + F(0) = 1 + 0 = 1

// 示例 2：
// 输入：3
// 输出：2
// 解释：F(3) = F(2) + F(1) = 1 + 1 = 2

// 示例 3：
// 输入：4
// 输出：3
// 解释：F(4) = F(3) + F(2) = 2 + 1 = 3

// 提示：
// 0 <= n <= 30

class Solution {
  /**
   * 递归
   *
   * @param n
   * @return
   */
  public int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

  /**
   * 带备忘录的递归实现
   *
   * @param n
   * @return
   */
  public int fib2(int n) {
    int[] arr = new int[n + 1];
    return dfs(arr, n);
  }

  public int dfs(int[] arr, int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    if (arr[n] != 0) {
      return arr[n];
    }
    arr[n] = dfs(arr, n - 1) + dfs(arr, n - 2);
    return arr[n];
  }

  /**
   * 动态规划
   * 状态转移方程：f(n) = f(n - 1) + f(n - 2)
   *
   * @param n
   * @return
   */
  public int fib3(int n) {
    if (n < 2) {
      return n;
    }
    // p, q, r三个变量的初始值都是在 i = 1的情况下的值
    int p = 0;
    int q = 0;
    int r = 1;
    // 使用滚动数组思想进行三个值的交换
    for (int i = 2; i <= n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
