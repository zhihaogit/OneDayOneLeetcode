/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfArithmeticSlices = function (nums) {
  let dp = 0;
  let ans = 0;

  for (let i = 2; i < nums.length; i++) {
    if (nums[i] - nums[i - 1] === nums[i - 1] - nums[i - 2]) {
      dp++;
      ans += dp;
    } else {
      dp = 0;
    }
  }

  return ans;
};
