/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const binarySearch = (nums, target, lower) => {
  let n = nums.length;
  let l = 0;
  let r = n - 1;
  while (l <= r) {
    const mid = Math.floor((l + r) / 2);
    if (nums[mid] > target || (lower && nums[mid] >= target)) {
      r = mid - 1;
      n = mid;
    } else {
      l = mid + 1;
    }
  }
  return n;
};

var searchRange = function (nums, target) {
  const li = binarySearch(nums, target, true);
  const ri = binarySearch(nums, target, false) - 1;
  if (li <= ri && ri < nums.length && nums[li] === target && target === nums[ri]) {
    return [li, ri];
  }
  return [-1, -1];
};
