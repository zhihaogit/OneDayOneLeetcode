import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

// 示例 1：
// 输入：[3,2,3]
// 输出：[3]

// 示例 2：
// 输入：nums = [1]
// 输出：[1]

// 示例 3：
// 输入：[1,1,1,3,3,2,2,2]
// 输出：[1,2]

// 提示：
// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109

// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

class Solution {
  /**
   * hashmap统计
   * 
   * @param nums
   * @return
   */
  public List<Integer> majorityElement(int[] nums) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    for (int num : nums) {
      if (numsMap.containsKey(num)) {
        numsMap.put(num, numsMap.get(num) + 1);
      } else {
        numsMap.put(num, 1);
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
      if (entry.getValue() > nums.length / 3) {
        ans.add(entry.getKey());
      }
    }
    return ans;
  }

  /**
   * 摩尔投票
   * 
   * @param nums
   * @return
   */
  public List<Integer> majorityElement1(int[] nums) {
    // 1. 求数组中出现次数多于 1/3的元素，最多有 2个元素，所以初始化两个投票计数器和模板变量
    Integer num1 = null;
    Integer num2 = null;
    int vote1 = 0;
    int vote2 = 0;

    // 2. 遍历过程中，开始投票
    // 2-1. 票数等于 0的时候重置变量
    // 2-2. 票数大于 0且当前元素相等时，计数器加一
    // 2-3. 票数大于 0且当前元素不等时，计数器减一
    for (int num : nums) {
      if (vote1 > 0 && num == num1) {
        vote1++;
      } else if (vote2 > 0 && num == num2) {
        vote2++;
      } else if (vote1 == 0) {
        num1 = num;
        vote1 = 1;
      } else if (vote2 == 0) {
        num2 = num;
        vote2 = 1;
      } else {
        vote1--;
        vote2--;
      }
    }

    // 3. 使用新的计数器，开始校验投票结果
    int cnt1 = 0;
    int cnt2 = 0;
    for (int num : nums) {
      if (vote1 > 0 && num == num1) {
        cnt1++;
      }
      if (vote2 > 0 && num == num2) {
        cnt2++;
      }
    }

    // 4. 根据两次投票结果，将数量大于 1/3的元素加入到结果集中
    List<Integer> ans = new ArrayList<>();
    if (vote1 > 0 && cnt1 > nums.length / 3) {
      ans.add(num1);
    }
    if (vote2 > 0 && cnt2 > nums.length / 3) {
      ans.add(num2);
    }
    return ans;
  }
}
