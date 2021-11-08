/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubarraySumCircular = function (nums) {
  let sum = nums[0];
  let dp = sum;
  let max = sum;
  let min = 0;
  for (let i = 1; i <= nums.length - 1; i++) {
    sum += nums[i];
    dp = Math.max(dp + nums[i], nums[i]);
    max = Math.max(dp, max);
  }

  dp = nums[0];
  for (let i = 1; i < nums.length - 1; i++) {
    dp = Math.min(dp + nums[i], nums[i]);
    min = Math.min(dp, min);
  }

  return Math.max(max, sum - min);
};
