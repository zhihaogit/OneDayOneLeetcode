// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

// 说明：
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

// 示例 1:
// 输入: [2,2,1]
// 输出: 1

// 示例 2:
// 输入: [4,1,2,1,2]
// 输出: 4

class Solution {
  /**
   * 异或解法
   * 
   * 异或运算满足交换律，a^b^a=a^a^b=b
   * 
   * @param nums
   * @return
   */
  public int singleNumber(int[] nums) {
    int ans = nums[0];
    for (int i = 1; i < nums.length; i++) {
      ans = ans ^ nums[i];
    }
    return ans;
  }

  /**
   * 先排序，再寻找
   * 
   * @param nums
   * @return
   */
  public int singleNumber1(int[] nums) {
    Arrays.sort(nums);
    int result = -1;
    for (int i = 0; i < nums.length; i++) {
      if (i == nums.length - 1) {
        result = nums[i];
      } else if (nums[i] == nums[i + 1]) {
        i++;
      } else {
        result = nums[i];
      }
    }
    return result;
  }
}
