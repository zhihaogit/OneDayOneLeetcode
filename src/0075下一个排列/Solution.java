class Solution {
  public void nextPermutation(int[] nums) {
    int n = nums.length;
    if (n < 2) {
      return;
    }
    boolean flag = false;
    for (int i = n - 1; i > 0; i--) {
      if (nums[i - 1] < nums[i]) {
        for (int j = n - 1; j >= i; j--) {
          if (nums[j] > nums[i - 1]) {
            this.exchangeValue(nums, i - 1, j);
            this.reverseArr(nums, i, n - 1);
            flag = true;
            break;
          }
        }
      }
      if (flag) {
        break;
      }
    }
    if (!flag) {
      this.reverseArr(nums, 0, n - 1);
    }
  }

  private void exchangeValue(int[] nums, int begin, int end) {
    int tmp = nums[begin];
    nums[begin] = nums[end];
    nums[end] = tmp;
  }

  private void reverseArr(int[] nums, int begin, int end) {
    while (begin < end) {
      this.exchangeValue(nums, begin++, end--);
    }
  }
}
