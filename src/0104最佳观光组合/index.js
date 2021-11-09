/**
 * @param {number[]} values
 * @return {number}
 */
var maxScoreSightseeingPair = function (values) {
  const n = values.length;
  let ans = 0;
  let dp = new Array(n).fill(0);
  dp[0] = values[0] + 0;
  for (let i = 1; i < n; i++) {
    dp[i] = Math.max(dp[i - 1], values[i - 1] + i - 1);
    ans = Math.max(ans, dp[i] + values[i] - i);
  }
  return ans;
};
