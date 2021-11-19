/**
 * @param {string} s
 * @return {number}
 */
var longestPalindromeSubseq = function (s) {
  const n = s.length;
  const dp = new Array(n).fill(0).map(_ => new Array(n).fill(0));
  for (let left = n - 1; left >= 0; left--) {
    dp[left][left] = 1;
    for (let right = left + 1; right < n; right++) {
      if (s[left] === s[right]) {
        dp[left][right] = dp[left + 1][right - 1] + 2;
      } else {
        dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
      }
    }
  }
  return dp[0][n - 1];
};
