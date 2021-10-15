/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function (n) {
  let str = '1';
  for (let i = 2; i <= n; i++) {
    let newStr = '';
    let l = 0;
    let r = 0;
    while (r < str.length) {
      while (r < str.length && str[l] === str[r]) {
        r++;
      }
      newStr = `${newStr}${r - l}${str[l]}`;
      l = r;
    }
    str = newStr;
  }
  return str;
};
