/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function (cost) {
  let p1 = 0;
  let p2 = 0;
  for (let i = 2; i <= cost.length; i++) {
    const next = Math.min(p2 + cost[i - 1], p1 + cost[i - 2])
    p1 = p2;
    p2 = next;
  }
  return p2;
};
