/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  if (!nums) return [];
  const arr = nums.sort((a, b) => a - b);
  const len = arr.length;
  if (len < 3 || arr[0] > 0 || arr[len - 1] < 0) return [];
  const res = [];
  for (let i = 0; i < len; i++) {
    if (arr[i] > 0) return res;
    if (i > 0 && arr[i] === arr[i - 1]) continue;
    let l = i + 1;
    let r = len - 1;
    while (l < r) {
      const sum = arr[i] + arr[l] + arr[r];
      if (sum < 0) {
        l++;
      } else if (sum > 0) {
        r--;
      } else {
        res.push([arr[i], arr[l], arr[r]]);
        while (l < r && arr[l] === arr[l + 1]) {
          l++;
        }
        while (l < r && arr[r] === arr[r - 1]) {
          r--;
        }
        l++;
        r--;
      }
    }
  }
  return res;
};

const origin = [-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6];
console.log(threeSum(origin));