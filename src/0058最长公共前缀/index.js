/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (!strs || !strs.length) return '';
  const lcp = (start, end) => {
    if (start === end) return strs[start];
    const mid = Math.floor((start + end) / 2);
    const lcpLeft = lcp(start, mid);
    const lcpRight = lcp(mid + 1, end);
    const count = Math.min(lcpLeft.length, lcpRight.length);
    for (let i = 0; i < count; i++) {
      if (lcpLeft[i] !== lcpRight[i]) return lcpLeft.slice(0, i);
    }
    return lcpLeft.slice(0, count);
  };
  return lcp(0, strs.length - 1);
};