// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

// 示例 1：
// 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出：6
// 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

// 示例 2：
// 输入：nums = [1]
// 输出：1

// 示例 3：
// 输入：nums = [0]
// 输出：0

// 示例 4：
// 输入：nums = [-1]
// 输出：-1

// 示例 5：
// 输入：nums = [-100000]
// 输出：-100000

// 提示：
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

class Solution {
  /**
   * 动态规划
   * 状态转移方程：f(i) = max(f(i - 1) + nums[i], nums[i])
   * f(i)代表以第 i个数结尾的连续子数组的最大和
   *
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    // 记录截止到前一位的最大和
    int pre = 0;
    // 记录连续数组的最大和
    int ans = nums[0];
    // 遍历数组
    for (int num : nums) {
      // 通过比较当前值和截止到前一位的最大和进行赋值，如果当前位置比较大，放弃之前的值，从当前位置开始
      pre = Math.max(pre + num, num);
      // 持续比较得到历史中的最大和
      ans = Math.max(pre, ans);
    }
    return ans;
  }

  /**
   * 分治法
   * 线段树
   *
   * @param nums
   * @return
   */
  public int maxSubArray1(int[] nums) {
    return getInfo(nums, 0, nums.length - 1).mSum;
  }

  public class Status {
    public int lSum; // 表示 [l,r]内以 l为左端点的最大子段和
    public int rSum; // 表示 [l,r]内以 r为右端点的最大子段和
    public int mSum; // 表示 [l,r]内的最大子段和
    public int iSum; // 表示 [l,r]的区间和

    public Status(int lSum, int rSum, int mSum, int iSum) {
      this.lSum = lSum;
      this.rSum = rSum;
      this.mSum = mSum;
      this.iSum = iSum;
    }
  }

  public Status getInfo(int[] nums, int l, int r) {
    if (l == r) {
      return new Status(nums[l], nums[l], nums[l], nums[l]);
    }
    int m = (l + r) >> 1;
    Status lStatus = getInfo(nums, l, m);
    Status rStatus = getInfo(nums, m + 1, r);
    return pushUp(lStatus, rStatus);
  }

  public Status pushUp(Status l, Status r) {
    int iSum = l.iSum + r.iSum;
    int lSum = Math.max(l.lSum, l.iSum + r.lSum);
    int rSum = Math.max(r.rSum, r.iSum + l.rSum);
    int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
    return new Status(lSum, rSum, mSum, iSum);
  }
}
