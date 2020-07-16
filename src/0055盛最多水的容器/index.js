/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let l = 0;
  let r = height.length - 1;
  let res = 0;
  while (l < r) {
    res = Math.max(res, (r - l) * (
      height[l] < height[r]
        ? height[l++]
        : height[r--]
    ));
  }
  return res;
};