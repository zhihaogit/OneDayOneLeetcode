/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
  let p1 = 0;
  let p2 = 0;
  let p3 = 1;
  for (let i = 1; i <= n; i++) {
    p1 = p2;
    p2 = p3;
    p3 = p1 + p2;
  }
  return p3;
};
