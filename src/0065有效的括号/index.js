/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  const n = s.length;
  if (n % 2 !== 0) return false;
  const map = new Map([
    [')', '('],
    [']', '['],
    ['}', '{'],
  ]);
  const stack = [];
  for (let i = 0; i < n; i++) {
    const ch = s[i];
    if (map.has(ch)) {
      if (!stack.length || stack[stack.length - 1] !== map.get(ch)) {
        return false;
      }
      stack.pop(ch);
    } else {
      stack.push(ch);
    }
  }
  return !stack.length;
};