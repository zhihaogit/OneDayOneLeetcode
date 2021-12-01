/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
  let count = 0;
  let tmp = null;
  for (let num of nums) {
    if (!count) {
      tmp = num;
      count = 1;
    } else {
      count += num === tmp ? 1 : -1;
    }
  }
  return tmp;
};
