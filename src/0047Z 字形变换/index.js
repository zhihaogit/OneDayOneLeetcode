/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows < 2) return s;
  let res = Array(numRows).fill('');
  let i = 0;
  let flag = -1;
  for (let j = 0; j < s.length; j++) {
    const c = s[j];
    res[i] += c;
    if (i === 0 || i === numRows - 1) flag = -flag;
    i += flag;
  }
  return res.join('');
};