// 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

// 示例 1：
// 输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]

// 示例 2：
// 输入：nums = [2,0,1]
// 输出：[0,1,2]

// 示例 3：
// 输入：nums = [0]
// 输出：[0]

// 示例 4：
// 输入：nums = [1]
// 输出：[1]

// 提示：
// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2

// 进阶：
// 你可以不使用代码库中的排序函数来解决这道题吗？
// 你能想出一个仅使用常数空间的一趟扫描算法吗？

class Solution {
  /**
   * 单指针 + 两次遍历
   * 
   * @param nums
   */
  public void sortColors(int[] nums) {
    int n = nums.length;
    // 记录已经排序的头部位置
    int pointer = 0;

    // 第一次遍历找到所有的 0，将 0放到数组头部，指针加 1
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        int tmp = nums[pointer];
        nums[pointer] = nums[i];
        nums[i] = tmp;
        pointer++;
      }
    }

    // 第二次遍历找到所有的 1，将 1放到数组头部，指针加 1
    for (int i = pointer; i < n; i++) {
      if (nums[i] == 1) {
        int tmp = nums[pointer];
        nums[pointer] = nums[i];
        nums[i] = tmp;
        pointer++;
      }
    }
  }

  /**
   * 双指针
   * 
   * 分别标记 0和 1的位置
   * 
   * @param nums
   */
  public void sortColors1(int[] nums) {
    int n = nums.length;
    // 记录头部中 0的位置
    int p0 = 0;
    // 记录头部中 1的位置
    int p1 = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) {
        // 如果当前位置等于 1，与 p1位置进行交换，p1指针加 1
        int tmp = nums[p1];
        nums[p1] = nums[i];
        nums[i] = tmp;
        p1++;
      } else if (nums[i] == 0) {
        // 如果当前位置等于 1，与 p0位置进行交换
        int tmp = nums[p0];
        nums[p0] = nums[i];
        nums[i] = tmp;
        // 如果 p0,p1不相等，则说明已有 1存在于头部，所以当前位置需要跟 p1交换数据
        if (p0 < p1) {
          int tmp1 = nums[p1];
          nums[p1] = nums[i];
          nums[i] = tmp1;
        }
        // 0插入头部，会影响到 1的位置，所以同时加 1
        p0++;
        p1++;
      }
    }
  }

  /**
   * 双指针
   * 
   * 分别标记 0和 2的位置
   * 
   * @param nums
   */
  public void sortColors2(int[] nums) {
    int i = 0;
    // 记录 0的位置
    int p0 = 0;
    // 记录 2的位置
    int p2 = nums.length - 1;
    while (i >= p0 && i <= p2) {
      if (nums[i] == 2) {
        // 如果当前位置等于 2，与末尾交换位置，指针减 1
        int tmp = nums[p2];
        nums[p2] = nums[i];
        nums[i] = tmp;
        p2--;
      } else if (nums[i] == 0) {
        // 如果当前位置等于 0，与头部交换位置，指针加 1
        int tmp = nums[p0];
        nums[p0] = nums[i];
        nums[i] = tmp;
        p0++;
        // 重置 i的位置，加速迭代
        if (i <= p0) {
          i = p0;
        }
      } else {
        // 等于 1的情况，自增
        i++;
      }
    }
  }
}
