/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function (nums) {
  const n = nums.length;
  if (n < 2) return n;
  const exchangeValues = (nums, begin, end) => [nums[begin], nums[end]] = [nums[end], nums[begin]];
  const reverseArr = (nums, begin, end) => {
    while (begin < end) {
      exchangeValues(nums, begin++, end--);
    }
  }
  let flag = false;
  for (let i = n - 1; i > 0; i--) {
    if (nums[i] > nums[i - 1]) {
      let min = n - 1;
      while (nums[min] <= nums[i - 1]) {
        min--;
      }
      exchangeValues(nums, i - 1, min);
      reverseArr(nums, i, n - 1);
      flag = true;
      break;
    }
  }

  if (!flag) reverseArr(nums, 0, n - 1);
};
