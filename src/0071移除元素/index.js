/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
  let i = 0;
  for (let j = 0; j < nums.length; j++) {
    if (nums[j] != val) {
      nums[i] = nums[j];
      i++;
    }
  }
  return i;
};

var removeElement1 = function (nums, val) {
  let [i, n] = [0, nums.length];
  while (i < n) {
    if (nums[i] == val) {
      nums[i] = nums[n - 1];
      n--;
    } else {
      i++;
    }
  }
  return i;
};

var removeElement2 = function (nums, val) {
  for (let i = nums.length; i >= 0; i--) {
    nums[i] === val && nums.splice(i, 1);
  }
  return nums.length;
};
