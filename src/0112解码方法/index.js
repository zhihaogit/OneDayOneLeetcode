/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
  let a = 0;
  let b = 1;
  let c = 0;
  for (let i = 1; i <= s.length; i++) {
    c = 0;
    if (s[i - 1] !== '0') {
      c += b;
    }
    if (i > 1 && s[i - 2] !== '0' && (+s[i - 2] * 10 + +s[i - 1]) <= 26) {
      c += a;
    }
    a = b;
    b = c;
  }
  return c;
};
