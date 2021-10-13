/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function (s, words) {
  const oneWordLen = words[0].length;
  const sLen = s.length;
  const wordsLen = words.length;
  const res = [];
  if (!sLen || !wordsLen || sLen < oneWordLen) {
    return res;
  }
  const wordsCounter = words.reduce((a, v) => ({
    ...a,
    [v]: a[v] ? a[v] + 1 : 1,
  }), {});
  for (let i = 0; i < oneWordLen; i++) {
    let left = i;
    let right = i;
    let tmpCnt = 0;
    let tmpCounter = {};
    while (right + oneWordLen <= sLen) {
      const tmp = s.substring(right, right + oneWordLen);
      right += oneWordLen;
      if (!wordsCounter[tmp]) {
        left = right;
        tmpCounter = {};
        tmpCnt = 0;
      } else {
        tmpCnt += 1;
        // 处理 tmp不存在于 tmpCounter，值为 undefined
        tmpCounter[tmp] = tmpCounter[tmp] ? tmpCounter[tmp] + 1 : 1;
        while (tmpCounter[tmp] > wordsCounter[tmp]) {
          const leftTmp = s.substring(left, left + oneWordLen);
          left += oneWordLen;
          tmpCnt -= 1;
          tmpCounter[leftTmp] -= 1;
        }
        if (tmpCnt === wordsLen) {
          res.push(left);
        }
      }
    }
  }
  return res;
};
