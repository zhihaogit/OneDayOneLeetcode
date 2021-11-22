/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
  const n = nums.length;
  const dp = new Array(n).fill(1);
  let maxAns = 1;
  for (let i = 1; i < n; i++) {
    for (let j = 0; j < i; j++) {
      if (nums[i] <= nums[j]) {
        continue;
      }
      nums[i] = Math.max(nums[i], nums[j] + 1);
    }
    maxAns = Math.max(maxAns, dp[i]);
  }
  return maxAns;
};
