/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
  const digits = [
    [1000, 'M'],
    [900, 'CM'],
    [500, 'D'],
    [400, 'CD'],
    [100, 'C'],
    [90, 'XC'],
    [50, 'L'],
    [40, 'XL'],
    [10, 'X'],
    [9, 'IX'],
    [5, 'V'],
    [4, 'IV'],
    [1, 'I']
  ];
  const romanDigits = [];
  for(let i = 0; i < digits.length; i++) {
    const [value, symbol] = digits[i];
    if (num === 0) break;
    let count = Math.floor(num / value);
    num %= value;
    romanDigits.push(symbol.repeat(count));
  }
  return romanDigits.join('');
};
