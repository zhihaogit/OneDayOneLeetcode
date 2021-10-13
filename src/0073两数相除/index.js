/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function (dividend, divisor) {
  let sign = 1
  if (dividend > 0 && divisor < 0) {
    sign = -1
    divisor = -divisor
  } else if (dividend < 0 && divisor > 0) {
    sign = -1
    dividend = -dividend
  } else if (dividend < 0 && divisor < 0) {
    dividend = -dividend
    divisor = -divisor
  }

  let remain = dividend;
  let result = 0;
  while (remain >= divisor) {
    let cur = 1;
    let div = divisor;
    while (div + div < remain) {
      cur += cur;
      div += div;
    }
    remain -= div;
    result += cur;
  }

  if (sign < 0) {
    result = -result;
  }

  if (result >= 2 ** 31) {
    result = 2 ** 31 - 1;
  }

  return result;
};
