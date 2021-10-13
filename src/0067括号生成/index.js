/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  if (!n) return [''];
  const ans = [];
  for (let i = 0; i < n; i++) {
    const left = generateParenthesis(i);
    for (let l = 0; l < left.length; l++) {
      const right = generateParenthesis(n - 1 - i);
      for (let r = 0; r < right.length; r++) {
        ans.push(`(${left[l]})${right[r]}`);
      }
    }
  }
  return ans;
};
