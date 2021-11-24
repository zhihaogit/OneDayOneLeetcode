/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  const backtrack = (index, nums, res, tmp) => {
    res.push([...tmp]);
    for (let i = index; i < nums.length; i++) {
      backtrack(i + 1, nums, res, [
        ...tmp,
        nums[i],
      ]);
    }
  };
  const res = [];
  backtrack(0, nums, res, []);
  return res;
};
