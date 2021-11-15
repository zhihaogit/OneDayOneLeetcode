/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {
  const dp = new Array(numRows).fill(0).map(() => new Array(numRows).fill(0));
  dp[0][0] = 1;
  const result = [[1]];
  for (let i = 1; i < numRows; i++) {
    const tmp = [];
    for (let j = 0; j <= i; j++) {
      if (j === 0) {
        dp[i][j] = 1;
      } else {
        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
      }
      tmp.push(dp[i][j]);
    }
    result.push(tmp);
  }
  return result;
};
