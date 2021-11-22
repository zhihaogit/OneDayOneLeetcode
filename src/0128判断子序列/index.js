/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function (s, t) {
  const n = s.length;
  const m = t.length;
  const aCode = 'a'.charCodeAt();
  const dp = new Array(m + 1).fill(0).map(_ => new Array(26).fill(0));
  for (let i = 0; i < 26; i++) {
    dp[m][i] = m;
  }

  for (let i = m - 1; i >= 0; i--) {
    for (let j = 0; j < 26; j++) {
      if (t[i].charCodeAt() === j + aCode) {
        dp[i][j] = i;
      } else {
        dp[i][j] = dp[i + 1][j];
      }
    }
  }

  let add = 0;
  for (let i = 0; i < n; i++) {
    if (dp[add][s[i].charCodeAt() - aCode] === m) {
      return false;
    }
    add = dp[add][s[i].charCodeAt() - aCode] + 1;
  }
  return true;
};
