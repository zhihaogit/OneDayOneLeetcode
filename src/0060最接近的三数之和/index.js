/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
  const arr = nums.sort((a, b) => a - b);
  const len = arr.length;
  let best = 10 ** 7;

  const update = (cur) => {
    if (Math.abs(cur - target) < Math.abs(best - target)) best = cur;
  };

  for (let i = 0; i < len; i++) {
    if (i > 0 && arr[i] === arr[i - 1]) continue;
    let l = i + 1;
    let r = len - 1;
    while (l < r) {
      const sum = nums[i] + nums[l] + nums[r];
      if (sum === target) return target;
      update(sum);
      if (sum > target) {
        while (l < r && nums[r] === nums[r - 1]) r--;
        r--;
      } else {
        while (l < r && nums[l] === nums[l + 1]) l++;
        l++;
      }
    }
  }
  return best;
};


const nums = [-1, 0, 1, 1, 55]
const target = 3
const res = threeSumClosest(nums, target)
console.log(res);
