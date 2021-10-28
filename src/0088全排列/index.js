/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
  const res = [];
  backtrack(0, res, nums, nums.length);
  return res;
};

var backtrack = function (first, res, output, n) {
  if (first == n) {
    res.push([...output]);
  }

  for (let i = first; i < n; i++) {
    [output[first], output[i]] = [output[i], output[first]];
    backtrack(first + 1, res, output, n);
    [output[first], output[i]] = [output[i], output[first]];
  }
};
