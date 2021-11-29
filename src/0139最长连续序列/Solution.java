import java.util.HashSet;
import java.util.Set;

// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

// 示例 1：
// 输入：nums = [100,4,200,1,3,2]
// 输出：4
// 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

// 示例 2：
// 输入：nums = [0,3,7,2,5,8,4,6,0,1]
// 输出：9

// 提示：
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109

class Solution {
  public int longestConsecutive(int[] nums) {
    // 题目中不追求元素在原数组中是连续的，可以用 set集合去重，忽略元素的原始顺序，减少查找过程
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }
    int maxLength = 0;
    // 遍历 set集合，用每一个元素查找连续的序列
    for (int num : numSet) {
      // 优化查找过程，如果元素的前一个值已经存在于集合中，说明已经被当做前一个值的连续部分，不需要重复计算
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentLength = 1;
        // 连续查找当前元素的后面元素
        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentLength++;
        }
        // 比较历史最大值
        maxLength = Math.max(maxLength, currentLength);
      }
    }
    return maxLength;
  }
}
