/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let dp = prices[0];
  let ans = 0;
  for (let i = 1; i < prices.length; i++) {
    dp = Math.min(dp, prices[i]);
    ans = Math.max(ans, prices[i] - dp);
  }
  return ans;
};
