/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function (n) {
  const dp = new Array(n + 1).fill(0);
  dp[0] = dp[1] = 0;
  for (let i = 2; i <= n; i++) {
    let max = 0;
    for (let j = 1; j < i; j++) {
      max = Math.max(max, j * (i - j), j * dp[i - j]);
    }
    dp[i] = max;
  }
  return dp[n];
};
