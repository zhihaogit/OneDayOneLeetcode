/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function (prices, fee) {
  let dp0 = 0;
  let dp1 = -prices[0];
  for (let i = 1; i < prices.length; i++) {
    [dp0, dp1] = [
      Math.max(dp0, dp1 + prices[i] - fee),
      Math.max(dp1, dp0 - prices[i]),
    ];
  }
  return dp0;
};
