/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
  if (x < 0 || (x !== 0 && x % 10 === 0)) return false;
  let num = 0;
  while (x > num) {
    num = num * 10 + x % 10;
    x = Math.floor(x / 10);
  }
  return x === num || x === Math.floor(num / 10);
};