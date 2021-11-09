/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let dp0 = 0;
  let dp1 = -prices[0];
  for (let i = 1; i < prices.length; i++) {
    const newDp0 = Math.max(dp0, dp1 + prices[i]);
    const newDp1 = Math.max(dp1, dp0 - prices[i]);
    dp0 = newDp0;
    dp1 = newDp1;
  }
  return dp0;
};
