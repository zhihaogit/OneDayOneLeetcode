/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
  const strX = x.toString();
  const len = strX.length - 1;
  let strXReverse = '';
  for (let i = len; i >= 0; i--) {
    strXReverse += strX[i];
  }
  if (strXReverse.endsWith('-')) {
    const numXReverse = +strXReverse.slice(0, len) * -1
    return numXReverse >= (2 ** 31 * -1)
      ? numXReverse
      : 0;
  }
  return +strXReverse <= (2 ** 31)
    ? +strXReverse
    : 0;
};
