// 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

// 示例 1：
// 输入：x = 2.00000, n = 10
// 输出：1024.00000

// 示例 2：
// 输入：x = 2.10000, n = 3
// 输出：9.26100

// 示例 3：
// 输入：x = 2.00000, n = -2
// 输出：0.25000
// 解释：2-2 = 1/22 = 1/4 = 0.25

// 提示：
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104

class Solution {
  /**
   * 快速幂 + 递归
   * 
   * @param x
   * @param n
   * @return
   */
  public double myPow1(double x, int n) {
    long N = n;
    return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
  }

  public double quickMul(double x, long N) {
    if (N == 0) {
      return 1.0;
    }
    // 持续递归向下查找最小的 N
    double y = quickMul(x, N / 2);
    // 如果 N是奇数，就多乘以 x
    return N % 2 == 0 ? y * y : y * y * x;
  }

  /**
   * 快速幂 + 迭代
   * 
   * @param x
   * @param n
   * @return
   */
  public double myPow2(double x, int n) {
    long N = n;
    return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
  }

  /**
   * 利用二进制的规律求解
   * x的77次方 = x的1次方 * x的4次方 * x的8次方 * x的64次方
   * 这些指数 11，44，88 和 64，恰好就对应了 7的二进制表示 (1001101)2中的每个 1
   *
   * @param x
   * @param N
   * @return
   */
  public double quickMul2(double x, long N) {
    double ans = 1.0;
    // x_contribute当作底数，一直进行相乘
    double x_contribute = x;
    while (N > 0) {
      // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
      if (N % 2 == 1) {
        ans *= x_contribute;
      }
      // N不断除以 2，底数一直平方
      x_contribute *= x_contribute;
      N /= 2;
    }
    return ans;
  }
}
