/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function (n) {
  if (n == 0) {
    return n;
  }
  if (n < 3) {
    return 1;
  }
  let p1 = 0;
  let p2 = 1;
  let p3 = 1;
  let p4 = p1 + p2 + p3;
  for (let i = 4; i <= n; i++) {
    p1 = p2;
    p2 = p3;
    p3 = p4;
    p4 = p1 + p2 + p3;
  }
  return p4;
};
