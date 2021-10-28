/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
  const backtrack = (nums, res, perm, index) => {
    if (index === nums.length) {
      res.push([...perm]);
      return;
    }

    for (let i = 0; i < nums.length; i++) {
      if (vis[i] || (i > 0 && nums[i] === nums[i - 1] && !vis[i - 1])) {
        continue;
      }
      vis[i] = true;
      backtrack(nums, res, [...perm, nums[i]], index + 1);
      vis[i] = false;
    }
  };
  const res = [];
  const vis = new Array(nums.length).fill(false);
  backtrack(nums.sort((a, b) => a - b), res, [], 0);
  return res;
};
