/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  const n = nums.length;
  if (n === 0) {
    return 0;
  }
  if (n === 1) {
    return nums[0];
  }
  if (n === 2) {
    return Math.max(nums[0], nums[1]);
  }
  const robOnce = (start, end, nums) => {
    let first = nums[start];
    let second = Math.max(nums[start], nums[start + 1]);

    for (let i = start + 2; i <= end; i++) {
      const next = Math.max(first + nums[i], second);
      first = second;
      second = next;
    }
    return second;
  };
  return Math.max(robOnce(0, n - 2, nums), robOnce(1, n - 1, nums));
};
