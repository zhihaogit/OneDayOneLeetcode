/**
 * @param {number[]} nums
 * @return {number}
 */
var getMaxLen = function (nums) {
  let positive = nums[0] > 0 ? 1 : 0;
  let negative = nums[0] < 0 ? 1 : 0;
  let maxLength = positive;
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] > 0) {
      positive++;
      negative = negative > 0 ? negative + 1 : 0;
    } else if (nums[i] < 0) {
      const newPositive = negative > 0 ? negative + 1 : 0;
      negative = positive + 1;
      positive = newPositive;
    } else {
      positive = 0;
      negative = 0;
    }
    maxLength = Math.max(maxLength, positive);
  }
  return maxLength;
};
