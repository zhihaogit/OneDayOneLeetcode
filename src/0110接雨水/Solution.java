import java.util.Deque;
import java.util.LinkedList;

// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 示例 1：
// 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出：6
// 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 

// 示例 2：
// 输入：height = [4,2,0,3,2,5]
// 输出：9

// 提示：
// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

class Solution {
  /**
   * 动态规划
   *
   * @param height
   * @return
   */
  public int trap(int[] height) {
    int n = height.length;
    if (n == 0) {
      return 0;
    }

    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    int ans = 0;

    // 从左遍历数组，与前一位的高度进行对比，形成一个以左侧高度的 dp数组
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }

    // 从右遍历数组，与后一位的高度进行对比，形成一个以右侧高度的 dp数组
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }

    // 遍历数组，当前位置的存水量取决于左右高度的最小值与当前位置实际高度的差值
    for (int i = 0; i < n; i++) {
      ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return ans;
  }

  /**
   * 单调栈
   * 
   * @param height
   * @return
   */
  public int trap1(int[] height) {
  }

  /**
   * 双指针
   * 
   * @param height
   * @return
   */
  public int trap2(int[] height) {
    int n = height.length;
    if (n == 0) {
      return 0;
    }

    // 左右指针初始化
    int left = 0;
    int right = n - 1;
    // 左右指针所在位置最大值初始化
    int leftMax = 0;
    int rightMax = 0;
    // 总计值
    int ans = 0;

    // 终止条件为左指针小于右指针
    while (left < right) {
      // 不断更新左右位置最大值
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);

      // 将左右指针位置上的值进行比较，以两者的最小值更新总计值
      // 并且位置不断更新
      if (height[left] < height[right]) {
        ans += leftMax - height[left];
        left++;
      } else {
        ans += rightMax - height[right];
        right--;
      }
    }
    return ans;
  }
}
