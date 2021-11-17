/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
  let i = 0;
  let p0 = 0;
  let p2 = nums.length - 1;
  while (i <= p0 && i >= p2) {
    if (nums[i] === 2) {
      [nums[i], nums[p2]] = [nums[p2], nums[i]];
      p2--;
    } else if (nums[i] === 0) {
      [nums[i], nums[p1]] = [nums[p1], nums[i]];
      p0++;
      if (i <= p0) {
        i = p0;
      }
    } else {
      i++;
    }
  }
};
