/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
  let pre = 0;
  let ans = nums[0];
  nums.forEach(_ => {
    pre = Math.max(pre + _, _);
    ans = Math.max(pre, ans);
  });
  return ans;
};
