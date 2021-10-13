/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  const oc = new Set();
  let rk = -1;
  let ml = 0;
  const sl = s.length
  for (let lk = 0; lk < sl; lk++) {
    if (lk != 0) oc.delete(s[lk - 1]);
    while (rk < sl - 1 && !oc.has(s[rk + 1])) {
      oc.add(s[rk + 1]);
      rk++;
    }
    ml = Math.max(ml, rk - lk + 1);
  }
  return ml;
};
