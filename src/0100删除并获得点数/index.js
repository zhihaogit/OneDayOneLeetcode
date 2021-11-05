/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function (nums) {
  const maxVal = Math.max(...nums);
  const sum = new Array(maxVal + 1).fill(0);
  for (let i = 0; i < nums.length; i++) {
    sum[nums[i]] += nums[i];
  }
  const rob = (sum) => {
    const n = sum.length;
    let first = sum[0];
    let second = sum[1];
    for (let i = 2; i < n; i++) {
      const next = Math.max(first + sum[i], second);
      first = second;
      second = next;
    }
    return second;
  };
  return rob(sum);
};
