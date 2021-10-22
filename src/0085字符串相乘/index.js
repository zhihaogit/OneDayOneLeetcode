/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function (num1, num2) {
  if (num1 === '0' || num2 === '0') {
    return '0';
  }
  const n1 = num1.length;
  const n2 = num2.length;
  const ans = new Array(n1 + n2).fill(0);
  for (let i = n1 - 1; i >= 0; i--) {
    const c1 = num1[i];
    for (let j = n2 - 1; j >= 0; j--) {
      const c2 = num2[j];
      ans[i + j + 1] += c1 * c2;
    }
  }

  for (let i = n1 + n2 - 1; i > 0; i--) {
    ans[i - 1] += Math.floor(ans[i] / 10);
    ans[i] %= 10;
  }

  let res = '';
  let index = ans[0] === 0 ? 1 : 0;
  while (index < n1 + n2) {
    res += ans[index];
    index++;
  }
  return res;
};

console.log(multiply('1234', '567'));
