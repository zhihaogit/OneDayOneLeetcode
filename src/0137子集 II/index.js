/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
  const backtrack = (index, nums, res, tmp) => {
    res.push([...tmp]);
    for (let i = index; i < nums.length; i++) {
      backtrack(i + 1, nums, res, [
        ...tmp,
        nums[i],
      ]);
      while (i < nums.length - 1 && nums[i] === nums[i + 1]) {
        i++;
      }
    }
  };

  const res = [];
  nums.sort((a, b) => a - b);
  backtrack(0, nums, res, []);
  return res;
};
