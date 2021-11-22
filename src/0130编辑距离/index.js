/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function (word1, word2) {
  const m = word1.length;
  const n = word2.length;

  if (m * n == 0) {
    return m + n;
  }

  const dp = new Array(m + 1).fill(0).map(_ => new Array(n + 1).fill(0));
  for (let i = 0; i <= m; i++) {
    dp[i][0] = i;
  }
  for (let i = 0; i <= n; i++) {
    dp[0][i] = i;
  }

  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      const left = dp[i - 1][j] + 1;
      const down = dp[i][j - 1] + 1;
      let leftDown = dp[i - 1][j - 1];
      if (word1[i - 1] !== word2[j - 1]) {
        leftDown++;
      }
      dp[i][j] = Math.min(left, down, leftDown);
    }
  }
  return dp[m][n];
};
