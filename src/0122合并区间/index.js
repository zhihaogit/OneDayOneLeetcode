/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
  intervals.sort((a, b) => a[0] - b[0]);
  const merged = [];
  for (let i = 0; i < intervals.length; i++) {
    const [L, R] = intervals[i];
    const final = merged[merged.length - 1] || [];
    if (!merged.length || final[1] < L) {
      merged.push(intervals[i]);
    } else {
      final[1] = Math.max(final[1], R);
    }
  }
  return merged;
};
