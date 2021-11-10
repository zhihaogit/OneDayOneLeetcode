/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let dp0 = -prices[0];
  let dp1 = 0;
  let dp2 = 0;
  for (let i = 1; i < prices.length; i++) {
    [
      dp0,
      dp1,
      dp2,
    ] = [
        Math.max(dp0, dp2 - prices[i]),
        dp0 + prices[i],
        Math.max(dp1, dp2),
      ]
  }
  return Math.max(dp1, dp2);
};
