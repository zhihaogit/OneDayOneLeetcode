/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  const hashMap = {};
  for (let i = 0; i < nums.length; i++) {
    const ele = nums[i];
    const difference = target - ele;
    if (difference in hashMap) {
      return [hashMap[difference], i];
    }
    hashMap[ele] = i;
  }
};