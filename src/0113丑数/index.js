/**
 * @param {number} n
 * @return {boolean}
 */
var isUgly = function (n) {
  if (n <= 0) return false;
  const arr = [2, 3, 5];
  for (const num of arr) {
    while (n % num === 0) {
      n /= num;
    }
  }
  return n === 1;
};
