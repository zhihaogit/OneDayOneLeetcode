import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    if (n < 4) {
      return res;
    }
    Arrays.sort(nums);
    for (int first = 0; first < n - 3; first++) {
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }
      for (int second = first + 1; second < n - 2; second++) {
        if (second > first + 1 && nums[second] == nums[second - 1]) {
          continue;
        }
        int third = second + 1;
        int fourth = n - 1;
        while (third < fourth) {
          int sumVal = nums[first] + nums[second] + nums[third] + nums[fourth];
          if (sumVal < target) {
            third += 1;
          } else if (sumVal > target) {
            fourth -= 1;
          } else {
            res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
            while (third < fourth && nums[third] == nums[third + 1]) {
              third += 1;
            }
            while (third < fourth && nums[fourth] == nums[fourth - 1]) {
              fourth -= 1;
            }
            third += 1;
            fourth -= 1;
          }
        }
      }
    }
    return res;
  }
}