/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  if (!digits) return [];
  const phoneMap = {
    '2': ['a', 'b', 'c'],
    '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'],
    '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'],
    '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'],
    '9': ['w', 'x', 'y', 'z']
  };
  const output = [];
  const recursion = (combine, nextDigits) => {
    if (!nextDigits.length) {
      output.push(combine);
    } else {
      const arr = phoneMap[nextDigits[0]]
      for (let i = 0; i < arr.length; i++) {
        recursion(combine + arr[i], nextDigits.slice(1));
      }
    }
  };
  recursion('', digits);
  return output;
};


const test = "23";
const res = letterCombinations(test);
console.log(res);

