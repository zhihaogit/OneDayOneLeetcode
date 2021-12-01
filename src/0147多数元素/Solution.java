import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

// 示例 1：
// 输入：[3,2,3]
// 输出：3

// 示例 2：
// 输入：[2,2,1,1,1,2,2]
// 输出：2

// 进阶：
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题

class Solution {
  /**
   * hashmap统计所有数字的出现次数之后，再遍历 hashmap找到出现次数最多的元素
   * 
   * @param nums
   * @return
   */
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    for (int key : nums) {
      if (numsMap.containsKey(key)) {
        numsMap.put(key, numsMap.get(key) + 1);
      } else {
        numsMap.put(key, 1);
      }
    }

    Map.Entry<Integer, Integer> maxItem = null;
    for (Map.Entry<Integer, Integer> map : numsMap.entrySet()) {
      if (maxItem == null || (maxItem.getValue() < map.getValue())) {
        maxItem = map;
      }
    }
    return maxItem.getKey();
  }

  /**
   * 排序之后，如果确定有众数，超过数组长度二分之一的索引指向的就是众数
   * 
   * @param nums
   * @return
   */
  public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length >> 1];
  }

  /**
   * 摩尔投票法
   * 
   * 主要是内部消耗，如果有众数，则说明数组中有一半为该值，至少比另一半的数字多一个
   * 
   * @param nums
   * @return
   */
  public int majorityElement2(int[] nums) {
    int count = 0;
    Integer result = null;
    for (int num : nums) {
      if (count == 0) {
        // 计数为 0的时候，重置记录元素
        result = num;
        count = 1;
      } else {
        // 值相同，计数加一，不同则减一
        count += result == num ? 1 : -1;
      }
    }
    return result;
  }
}
