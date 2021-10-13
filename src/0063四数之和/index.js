/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function (nums, target) {
  const n = nums.length;
  const res = [];
  if (n < 4) return res;
  const arr = nums.sort((a, b) => a - b);
  for (let first = 0; first < n - 3; first++) {
    if (first > 0 && arr[first] === arr[first - 1]) {
      continue;
    }
    for (let second = first + 1; second < n - 2; second++) {
      if (second > first + 1 && arr[second] === arr[second - 1]) {
        continue;
      }
      let third = second + 1;
      let fourth = n - 1;
      while (third < fourth) {
        const sumVal = arr[first] + arr[second] + arr[third] + arr[fourth];
        if (sumVal < target) {
          third += 1;
        } else if (sumVal > target) {
          fourth -= 1;
        } else {
          res.push([arr[first], arr[second], arr[third], arr[fourth]]);
          while (third < fourth && arr[third] === arr[third + 1]) {
            third += 1;
          }
          while (third < fourth && arr[fourth] === arr[fourth - 1]) {
            fourth -= 1;
          }
          third += 1;
          fourth -= 1;
        }
      }
    }
  }
  return res;
};
