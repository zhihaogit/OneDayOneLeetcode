/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function (nums) {
  let ans = nums[0];
  let max = ans;
  let min = ans;
  for (let i = 1; i < nums.length; i++) {
    const mx = max;
    const mn = min;
    const cur = nums[i];
    max = Math.max(mx * cur, mn * cur, cur);
    min = Math.min(mn * cur, mx * cur, cur);
    ans = Math.max(max, ans);
  }
  return ans;
};
